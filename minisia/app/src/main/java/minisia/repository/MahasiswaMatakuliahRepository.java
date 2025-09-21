package minisia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import minisia.models.MahasiswaMatakuliah;

public class MahasiswaMatakuliahRepository {

  private Connection conn;

  public MahasiswaMatakuliahRepository(Connection conn) {
    this.conn = conn;
  }

  public List<MahasiswaMatakuliah> findAll() throws SQLException {
    List<MahasiswaMatakuliah> list = new ArrayList<>();
    String sql = "SELECT nim, kode_matakuliah, indeks_nilai FROM mahasiswa_matakuliah";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      String nim = rs.getString("nim");
      String kodeMk = rs.getString("kode_matakuliah");
      String indeksNilai = rs.getString("indeks_nilai");
      MahasiswaMatakuliah mmk = new MahasiswaMatakuliah(nim, kodeMk, indeksNilai);
      list.add(mmk);
    }
    return list;
  }

  public Optional<MahasiswaMatakuliah> findByNimAndKodeMk(String nim, String kodeMk) throws SQLException {
    String sql = "SELECT nim, kode_matakuliah, indeks_nilai FROM mahasiswa_matakuliah WHERE nim = ? AND kode_matakuliah = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nim);
    stmt.setString(2, kodeMk);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      String indeksNilai = rs.getString("indeks_nilai");
      MahasiswaMatakuliah mmk = new MahasiswaMatakuliah(nim, kodeMk, indeksNilai);
      return Optional.of(mmk);
    }
    return Optional.empty();
  }

  public List<MahasiswaMatakuliah> findByNim(String nim) throws SQLException {
    List<MahasiswaMatakuliah> list = new ArrayList<>();
    String sql = "SELECT nim, kode_matakuliah, indeks_nilai FROM mahasiswa_matakuliah WHERE nim = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nim);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      String kodeMk = rs.getString("kode_matakuliah");
      String indeksNilai = rs.getString("indeks_nilai");
      MahasiswaMatakuliah mmk = new MahasiswaMatakuliah(nim, kodeMk, indeksNilai);
      list.add(mmk);
    }
    return list;
  }

  public List<MahasiswaMatakuliah> findByKodeMk(String kodeMk) throws SQLException {
    List<MahasiswaMatakuliah> list = new ArrayList<>();
    String sql = "SELECT nim, kode_matakuliah, indeks_nilai FROM mahasiswa_matakuliah WHERE kode_matakuliah = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, kodeMk);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      String nim = rs.getString("nim");
      String indeksNilai = rs.getString("indeks_nilai");
      MahasiswaMatakuliah mmk = new MahasiswaMatakuliah(nim, kodeMk, indeksNilai);
      list.add(mmk);
    }
    return list;
  }

  public boolean insert(MahasiswaMatakuliah mmk) throws SQLException {
    String sql = "INSERT INTO mahasiswa_matakuliah (nim, kode_matakuliah, indeks_nilai) VALUES (?, ?, ?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, mmk.getNim());
    stmt.setString(2, mmk.getKodeMatakuliah());
    stmt.setString(3, mmk.getIndeksNilai());
    stmt.executeUpdate();
    return true;
  }

  public boolean update(MahasiswaMatakuliah mmk) throws SQLException {
    String sql = "UPDATE mahasiswa_matakuliah SET indeks_nilai = ? WHERE nim = ? AND kode_matakuliah = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, mmk.getIndeksNilai());
    stmt.setString(2, mmk.getNim());
    stmt.setString(3, mmk.getKodeMatakuliah());
    int rowsAffected = stmt.executeUpdate();
    return rowsAffected > 0;
  }

  public boolean delete(String nim, String kodeMk) throws SQLException {
    String sql = "DELETE FROM mahasiswa_matakuliah WHERE nim = ? AND kode_matakuliah = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nim);
    stmt.setString(2, kodeMk);
    int rowsAffected = stmt.executeUpdate();
    return rowsAffected > 0;
  }

  public boolean deleteByNim(String nim) throws SQLException {
    String sql = "DELETE FROM mahasiswa_matakuliah WHERE nim = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nim);
    int rowsAffected = stmt.executeUpdate();
    return rowsAffected > 0;
  }

  public boolean deleteByKodeMk(String kodeMk) throws SQLException {
    String sql = "DELETE FROM mahasiswa_matakuliah WHERE kode_matakuliah = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, kodeMk);
    int rowsAffected = stmt.executeUpdate();
    return rowsAffected > 0;
  }
}