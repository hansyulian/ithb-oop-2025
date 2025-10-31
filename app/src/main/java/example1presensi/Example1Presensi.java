package example1presensi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Example1Presensi {

  public List<PresensiSummary> contoh(String nim) throws SQLException {
    List<PresensiSummary> presensiSummaryList = new ArrayList<>();
    Connection connection = Database.connect();
    String sql = "Select kodeMataKuliah, sum(case when status ='hadir' then 1 else 0 end) as hadir, sum(case when status = 'alpha' then 1 else 0 end) as alpha, sum(case when status = 'sakit' then 1 else 0 end) as sakit from Presensi where nim = ? group by kodeMataKuliah";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, nim);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      String kodeMataKuliah = resultSet.getString("kodeMataKuliah");
      int hadir = resultSet.getInt("hadir");
      int alpha = resultSet.getInt("alpha");
      int sakit = resultSet.getInt("sakit");
      PresensiSummary presensiSummary = new PresensiSummary(nim, kodeMataKuliah, hadir, alpha, sakit);
      presensiSummaryList.add(presensiSummary);
    }
    return presensiSummaryList;
  }

  public static void main(String[] args) throws SQLException {
    Example1Presensi app = new Example1Presensi();

    List<PresensiSummary> contohCara1 = app.contoh("NIM001");

    for (PresensiSummary presensiSummary : contohCara1) {
      System.out.println(presensiSummary);
    }
  }
}
