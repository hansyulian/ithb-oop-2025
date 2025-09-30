package minisia.models;

public class Jurusan {
    private String kode;
    private String nama;

    // Constructors
    public Jurusan() {
    }

    public Jurusan(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return "kode: " + kode + ", nama: " + nama;
    }
}