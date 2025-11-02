package praktek10generic.repositories;

import praktek10generic.models.*;
import praktek10generic.models.enums.TipeStaff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffRepository {

  public List<Staff> findAll() throws SQLException {
    List<Staff> list = new ArrayList<>();
    String sql = "SELECT nik, nama, tipe, gajiPokok, honorPerSks FROM staff";

    Connection conn = Database.connect();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      String nik = rs.getString("nik");
      String nama = rs.getString("nama");
      TipeStaff tipe = TipeStaff.valueOf(rs.getString("tipe"));

      if (tipe == TipeStaff.DOSEN_TETAP) {
        double gajiPokok = rs.getDouble("gajiPokok");
        list.add(new DosenTetap(nik, nama, tipe, gajiPokok));
      } else {
        double honorPerSks = rs.getDouble("honorPerSks");
        list.add(new DosenHonorer(nik, nama, tipe, honorPerSks));
      }
    }

    rs.close();
    stmt.close();
    conn.close();
    return list;
  }

  public Staff findByNik(String nik) throws SQLException {
    String sql = "SELECT nik, nama, tipe, gajiPokok, honorPerSks FROM staff WHERE nik = ?";
    Staff staff = null;

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nik);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
      String nama = rs.getString("nama");
      TipeStaff tipe = TipeStaff.valueOf(rs.getString("tipe"));

      if (tipe == TipeStaff.DOSEN_TETAP) {
        double gajiPokok = rs.getDouble("gajiPokok");
        staff = new DosenTetap(nik, nama, tipe, gajiPokok);
      } else {
        double honorPerSks = rs.getDouble("honorPerSks");
        staff = new DosenHonorer(nik, nama, tipe, honorPerSks);
      }
    }

    rs.close();
    stmt.close();
    conn.close();
    return staff;
  }

  public boolean insert(Staff staff) throws SQLException {
    String sql = "INSERT INTO staff (nik, nama, tipe, gajiPokok, honorPerSks) VALUES (?, ?, ?, ?, ?)";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, staff.nik);
    stmt.setString(2, staff.nama);
    stmt.setString(3, staff.tipe.name());

    if (staff instanceof DosenTetap) {
      stmt.setDouble(4, ((DosenTetap) staff).gajiPokok);
      stmt.setNull(5, Types.DOUBLE);
    } else if (staff instanceof DosenHonorer) {
      stmt.setNull(4, Types.DOUBLE);
      stmt.setDouble(5, ((DosenHonorer) staff).honorPerSks);
    } else {
      stmt.setNull(4, Types.DOUBLE);
      stmt.setNull(5, Types.DOUBLE);
    }

    boolean result = stmt.executeUpdate() > 0;
    stmt.close();
    conn.close();
    return result;
  }

  public boolean update(Staff staff) throws SQLException {
    String sql = "UPDATE staff SET nama = ?, tipe = ?, gajiPokok = ?, honorPerSks = ? WHERE nik = ?";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, staff.nama);
    stmt.setString(2, staff.tipe.name());

    if (staff instanceof DosenTetap) {
      stmt.setDouble(3, ((DosenTetap) staff).gajiPokok);
      stmt.setNull(4, Types.DOUBLE);
    } else if (staff instanceof DosenHonorer) {
      stmt.setNull(3, Types.DOUBLE);
      stmt.setDouble(4, ((DosenHonorer) staff).honorPerSks);
    } else {
      stmt.setNull(3, Types.DOUBLE);
      stmt.setNull(4, Types.DOUBLE);
    }

    stmt.setString(5, staff.nik);

    boolean result = stmt.executeUpdate() > 0;
    stmt.close();
    conn.close();
    return result;
  }

  public boolean delete(String nik) throws SQLException {
    String sql = "DELETE FROM staff WHERE nik = ?";

    Connection conn = Database.connect();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nik);

    boolean result = stmt.executeUpdate() > 0;
    stmt.close();
    conn.close();
    return result;
  }
}
