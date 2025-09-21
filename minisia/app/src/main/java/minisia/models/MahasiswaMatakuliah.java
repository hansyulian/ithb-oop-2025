package minisia.models;

public class MahasiswaMatakuliah {
  private String nim;
  private String kodeMatakuliah;
  private String indeksNilai;

  public MahasiswaMatakuliah() {
  }

  public MahasiswaMatakuliah(String nim, String kodeMatakuliah, String indeksNilai) {
    this.nim = nim;
    this.kodeMatakuliah = kodeMatakuliah;
    this.indeksNilai = indeksNilai;
  }

  public String getNim() {
    return nim;
  }

  public String getKodeMatakuliah() {
    return kodeMatakuliah;
  }

  public String getIndeksNilai() {
    return indeksNilai;
  }
}