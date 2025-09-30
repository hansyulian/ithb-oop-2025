package minisia.models;

public class Matakuliah {
    private String kode;
    private String nama;
    private int sks;
    private String kodeJurusan;

    public Matakuliah(String kode, String nama, int sks, String kodeJurusan) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kodeJurusan = kodeJurusan;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }

    public String getKodeJurusan() {
        return kodeJurusan;
    }
}