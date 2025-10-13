package kuis2.models;

public class Sofa extends Kursi {
  private int jumlahDudukan;

  public Sofa(BahanUtama bahanUtama, double berat, int jumlahDudukan) {
    super(bahanUtama, berat, true);
    this.jumlahDudukan = jumlahDudukan;
  }

  public int getJumlahDudukan() {
    return this.jumlahDudukan;
  }

  @Override
  public String getNamaProduk() {
    return "Sofa";
  }

}
