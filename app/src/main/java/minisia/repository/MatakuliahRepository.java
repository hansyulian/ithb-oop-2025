package minisia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import minisia.models.Matakuliah;

public class MatakuliahRepository {

  private final Connection conn;

  public MatakuliahRepository(Connection conn) {
    this.conn = conn;
  }

  public List<Matakuliah> findAll() throws SQLException {
    List<Matakuliah> list = new ArrayList<>();
    String sql = "SELECT kode_matakuliah, nama, sks, kode_jurusan FROM matakuliah";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      String kode = rs.getString("kode_matakuliah");
      String nama = rs.getString("nama");
      int sks = rs.getInt("sks");
      String kodeJurusan = rs.getString("kode_jurusan");
      Matakuliah mk = new Matakuliah(kode, nama, sks, kodeJurusan);
      list.add(mk);
    }
    return list;
  }

  public Optional<Matakuliah> findByKode(String kode) throws SQLException {
    String sql = "SELECT kode_matakuliah, nama, sks, kode_jurusan FROM matakuliah WHERE kode_matakuliah = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, kode);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      String nama = rs.getString("nama");
      int sks = rs.getInt("sks");
      String kodeJurusan = rs.getString("kode_jurusan");
      Matakuliah mk = new Matakuliah(kode, nama, sks, kodeJurusan);
      return Optional.of(mk);
    }
    return Optional.empty();
  }

  public boolean insert(Matakuliah matakuliah) throws SQLException {
    String sql = "INSERT INTO matakuliah (kode_matakuliah, nama, sks, kode_jurusan) VALUES (?, ?, ?, ?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, matakuliah.getKode());
    stmt.setString(2, matakuliah.getNama());
    stmt.setInt(3, matakuliah.getSks());
    stmt.setString(4, matakuliah.getKodeJurusan());
    stmt.executeUpdate();
    return true;
  }

  public boolean update(Matakuliah matakuliah) throws SQLException {
    String sql = "UPDATE matakuliah SET nama = ?, sks = ?, kode_jurusan = ? WHERE kode_matakuliah = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, matakuliah.getNama());
    stmt.setInt(2, matakuliah.getSks());
    stmt.setString(3, matakuliah.getKodeJurusan());
    stmt.setString(4, matakuliah.getKode());
    int rowsAffected = stmt.executeUpdate();
    return rowsAffected > 0;
  }

  public boolean delete(String kode) throws SQLException {
    String sql = "DELETE FROM matakuliah WHERE kode_matakuliah = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, kode);
    int rowsAffected = stmt.executeUpdate();
    return rowsAffected > 0;
  }
}