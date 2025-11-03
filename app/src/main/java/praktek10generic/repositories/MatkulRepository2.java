package praktek10generic.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import praktek10generic.exceptions.DeleteFailedException;
import praktek10generic.models.Matkul;
import praktek10generic.models.enums.TableFieldType;

public class MatkulRepository2 extends GenericRepository<Matkul> {

  @Override
  protected List<TableFieldSpec<Matkul>> getFields() {
    List<TableFieldSpec<Matkul>> fields = new ArrayList<>();
    fields.add(new TableFieldSpec<>("kode", TableFieldType.STRING, m -> m.kode));
    fields.add(new TableFieldSpec<>("nama", TableFieldType.STRING, m -> m.nama));
    fields.add(new TableFieldSpec<>("sks", TableFieldType.INTEGER, m -> m.sks));
    return fields;
  }

  @Override
  protected String getPrimaryKey() {
    return "kode";
  }

  @Override
  protected String getTableName() {
    return "matkul";
  }

  @Override
  protected Matkul convertResultSet(ResultSet rs) throws SQLException {
    String kode = rs.getString("kode");
    String nama = rs.getString("nama");
    int sks = rs.getInt("sks");
    return new Matkul(kode, nama, sks);
  }

  public static void main(String[] args) throws SQLException, DeleteFailedException {
    MatkulRepository2 repository = new MatkulRepository2();
    repository.insert(new Matkul("MK011", "Hans", 4));
    try {
      List<Matkul> list = repository.findAll();
      for (Matkul matkul : list) {
        System.out.println(matkul);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
