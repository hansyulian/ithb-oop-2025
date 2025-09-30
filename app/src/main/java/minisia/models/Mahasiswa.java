package minisia.models;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String kodeJurusan;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama, String kodeJurusan) {
        this.nim = nim;
        this.nama = nama;
        this.kodeJurusan = kodeJurusan;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKodeJurusan() {
        return kodeJurusan;
    }
}