package praktek10generic.repositories;

import praktek10generic.models.Matkul;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatkulRepository {

  public List<Matkul> findAll() throws SQLException {
    List<Matkul> list = new ArrayList<>();
    String sql = "SELECT kode, nama, sks FROM matkul";

    Connection conn = Database.connect();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      list.add(new Matkul(
          rs.getString("kode"),
          rs.getString("nama"),
          rs.getInt("sks")));
    }

    rs.close();
    stmt.close();
    conn.close();
    return list;
  }

  public Matkul findByKode(String kode) throws SQLException {
    String sql = "SELECT kode, nama, sks FROM matkul WHERE kode = ?";
    Matkul matkul = null;

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, kode);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
      matkul = new Matkul(
          rs.getString("kode"),
          rs.getString("nama"),
          rs.getInt("sks"));
    }

    rs.close();
    stmt.close();
    conn.close();
    return matkul;
  }

  public boolean insert(Matkul matkul) throws SQLException {
    String sql = "INSERT INTO matkul (kode, nama, sks) VALUES (?, ?, ?)";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, matkul.kode);
    stmt.setString(2, matkul.nama);
    stmt.setInt(3, matkul.sks);

    boolean result = stmt.executeUpdate() > 0;
    stmt.close();
    conn.close();
    return result;
  }

  public boolean update(Matkul matkul) throws SQLException {
    String sql = "UPDATE matkul SET nama = ?, sks = ? WHERE kode = ?";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, matkul.nama);
    stmt.setInt(2, matkul.sks);
    stmt.setString(3, matkul.kode);

    boolean result = stmt.executeUpdate() > 0;
    stmt.close();
    conn.close();
    return result;
  }

  public boolean delete(String kode) throws SQLException {
    String sql = "DELETE FROM matkul WHERE kode = ?";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, kode);

    boolean result = stmt.executeUpdate() > 0;
    stmt.close();
    conn.close();
    return result;
  }
}
