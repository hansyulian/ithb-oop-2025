package minisia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import minisia.models.Jurusan;

public class JurusanRepository {

    private Connection conn;

    public JurusanRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Jurusan> findAll() throws SQLException {
        List<Jurusan> list = new ArrayList<>();
        String sql = "SELECT kode_jurusan, nama FROM jurusan";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String kode = resultSet.getString("kode_jurusan");
            String nama = resultSet.getString("nama");
            Jurusan jurusan = new Jurusan(kode, nama);
            list.add(jurusan);
        }
        return list;
    }

    public Optional<Jurusan> findByKode(String kode) throws SQLException {
        String sql = "SELECT kode_jurusan, nama FROM jurusan WHERE kode_jurusan = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, kode);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String nama = resultSet.getString("nama");
            Jurusan jurusan = new Jurusan(kode, nama);
            return Optional.of(jurusan);
        }
        return Optional.empty();
    }

    public boolean insert(Jurusan jurusan) throws SQLException {
        String sql = "INSERT INTO jurusan (kode_jurusan, nama) VALUES (?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, jurusan.getKode());
        preparedStatement.setString(2, jurusan.getNama());
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean update(Jurusan jurusan) throws SQLException {
        String sql = "UPDATE jurusan SET nama = ? WHERE kode_jurusan = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, jurusan.getNama());
        preparedStatement.setString(2, jurusan.getKode());
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }

    public boolean delete(String kode) throws SQLException {
        String sql = "DELETE FROM jurusan WHERE kode_jurusan = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, kode);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }
}