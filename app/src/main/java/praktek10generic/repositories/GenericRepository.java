package praktek10generic.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import praktek10generic.exceptions.DeleteFailedException;
import praktek10generic.exceptions.NotFoundException;

public abstract class GenericRepository<T> {

  protected abstract List<TableFieldSpec<T>> getFields();

  protected abstract String getPrimaryKey();

  protected abstract String getTableName();

  protected abstract T convertResultSet(ResultSet rs) throws SQLException;

  private String getAllFieldsSelect() {
    List<TableFieldSpec<T>> fields = getFields();
    List<String> fieldNames = new ArrayList<>();

    for (TableFieldSpec<T> field : fields) {
      fieldNames.add(field.name);
    }

    return String.join(", ", fieldNames);
  }

  public List<T> findAll() throws SQLException {
    List<T> list = new ArrayList<>();
    String sql = "SELECT " + getAllFieldsSelect() + " FROM " + getTableName();

    Connection conn = Database.connect();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      T record = convertResultSet(rs);
      list.add(record);
    }

    rs.close();
    stmt.close();
    conn.close();
    return list;
  }

  public T findByPk(String primaryKeyValue) throws SQLException, NotFoundException {
    String sql = "SELECT " + getAllFieldsSelect() + " FROM " + getTableName() + " WHERE " + getPrimaryKey() + " = ?";
    T result = null;

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, primaryKeyValue);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
      result = convertResultSet(rs);
    } else {
      throw new NotFoundException();
    }

    rs.close();
    stmt.close();
    conn.close();
    return result;
  }

  public void insert(T value) throws SQLException {
    String allFields = String.join(", ", java.util.Collections.nCopies(getFields().size(), "?"));
    String sql = "INSERT INTO " + getTableName() + " (" + getAllFieldsSelect() + ") VALUES ( "
        + allFields + ")";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);

    for (int i = 0; i < getFields().size(); i++) {
      TableFieldSpec<T> field = getFields().get(i);
      Object val = field.getValue.apply(value);
      if (val == null) {
        int sqlType = switch (field.type) {
          case STRING -> java.sql.Types.VARCHAR;
          case DOUBLE -> java.sql.Types.DOUBLE;
          case INTEGER -> java.sql.Types.INTEGER;
          case BOOLEAN -> java.sql.Types.BOOLEAN;
        };
        stmt.setNull(i + 1, sqlType);
      } else {
        stmt.setObject(i + 1, val);
      }
    }
    stmt.executeUpdate();
    stmt.close();
    conn.close();
  }

  public void update(String pk, T value) throws SQLException {
    // Build dynamic SET clause like "col1 = ?, col2 = ?"
    List<String> setClauses = new ArrayList<>();
    for (TableFieldSpec<T> field : getFields()) {
      if (!field.name.equals(getPrimaryKey())) {
        setClauses.add(field.name + " = ?");
      }
    }

    String sql = "UPDATE " + getTableName() + " SET "
        + String.join(", ", setClauses)
        + " WHERE " + getPrimaryKey() + " = ?";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);

    int paramIndex = 1;
    for (TableFieldSpec<T> field : getFields()) {
      if (field.name.equals(getPrimaryKey()))
        continue;
      Object val = field.getValue.apply(value);
      if (val == null) {
        int sqlType = switch (field.type) {
          case STRING -> java.sql.Types.VARCHAR;
          case DOUBLE -> java.sql.Types.DOUBLE;
          case INTEGER -> java.sql.Types.INTEGER;
          case BOOLEAN -> java.sql.Types.BOOLEAN;
        };
        stmt.setNull(paramIndex++, sqlType);
      } else {
        stmt.setObject(paramIndex++, val);
      }
    }

    // Set primary key for WHERE clause
    stmt.setString(paramIndex, pk);

    stmt.executeUpdate();
    stmt.close();
    conn.close();
  }

  public void delete(String pk) throws SQLException, DeleteFailedException {
    String sql = "DELETE FROM " + getTableName() + " WHERE " + getPrimaryKey() + " = ?";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, pk);

    boolean result = stmt.executeUpdate() > 0;
    if (!result) {
      throw new DeleteFailedException();
    }
    stmt.close();
    conn.close();
  }

}
