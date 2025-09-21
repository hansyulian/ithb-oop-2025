package minisia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import minisia.models.Mahasiswa;

public class MahasiswaRepository {

    private Connection conn;

    public MahasiswaRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Mahasiswa> findAll() throws SQLException {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT nim, nama, kode_jurusan FROM mahasiswa";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String nim = rs.getString("nim");
            String nama = rs.getString("nama");
            String kodeJurusan = rs.getString("kode_jurusan");
            Mahasiswa mhs = new Mahasiswa(nim, nama, kodeJurusan);
            list.add(mhs);
        }
        return list;
    }

    public Optional<Mahasiswa> findByNim(String nim) throws SQLException {
        String sql = "SELECT nim, nama, kode_jurusan FROM mahasiswa WHERE nim = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nim);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String nama = rs.getString("nama");
            String kodeJurusan = rs.getString("kode_jurusan");
            Mahasiswa mhs = new Mahasiswa(nim, nama, kodeJurusan);
            return Optional.of(mhs);
        }
        return Optional.empty();
    }

    public boolean insert(Mahasiswa mahasiswa) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nim, nama, kode_jurusan) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, mahasiswa.getNim());
        stmt.setString(2, mahasiswa.getNama());
        stmt.setString(3, mahasiswa.getKodeJurusan());
        stmt.executeUpdate();
        return true;
    }

    public boolean update(Mahasiswa mahasiswa) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama = ?, kode_jurusan = ? WHERE nim = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, mahasiswa.getNama());
        stmt.setString(2, mahasiswa.getKodeJurusan());
        stmt.setString(3, mahasiswa.getNim());
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    public boolean delete(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nim);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }
}