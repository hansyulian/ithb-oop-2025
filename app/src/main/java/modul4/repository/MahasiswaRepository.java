package modul4.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modul4.util.Database;

public class MahasiswaRepository {

  public void add(String nim, String kodeJurusan, String nama, String tempatLahir, String tanggalLahir,
      String alamat,
      String telepon) {
    Connection conn = Database.connect();
    String sql = "INSERT INTO mahasiswa (nim, nama, kodeJurusan, tempatLahir, tanggalLahir, alamat, telepon) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
      PreparedStatement preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1, nim);
      preparedStatement.setString(2, nama);
      preparedStatement.setString(3, kodeJurusan);
      preparedStatement.setString(4, tempatLahir);
      preparedStatement.setString(5, tanggalLahir);
      preparedStatement.setString(6, alamat);
      preparedStatement.setString(7, telepon);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
