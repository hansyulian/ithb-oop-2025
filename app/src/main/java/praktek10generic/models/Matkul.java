package praktek10generic.models;

public class Matkul {
  public String kode;
  public String nama;
  public int sks;

  public Matkul(String kode, String nama, int sks) {
    this.kode = kode;
    this.nama = nama;
    this.sks = sks;
  }

  @Override
  public String toString() {
    return "Matkul{" +
        "kode='" + kode + '\'' +
        ", nama='" + nama + '\'' +
        ", sks=" + sks +
        '}';
  }
}
