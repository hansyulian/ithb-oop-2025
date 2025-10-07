package modul4.models;

public class Mahasiswa extends User {
  private String nim;
  private String kodeJurusan;

  public Mahasiswa(String nim, String kodeJurusan, String nama, String tempatLahir, String tanggalLahir, String alamat,
      String telepon) {
    super(UserType.MAHASISWA, nama, tempatLahir, tanggalLahir, alamat, telepon);
    this.nim = nim;
    this.kodeJurusan = kodeJurusan;
  }

  public String getNim() {
    return nim;
  }

  public String getKodeJurusan() {
    return kodeJurusan;
  }

}
