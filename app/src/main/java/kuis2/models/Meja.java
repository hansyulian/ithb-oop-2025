package kuis2.models;

public class Meja extends Furnitur {
  private int jumlahLaci;

  public Meja(BahanUtama bahanUtama, double berat, int jumlahLaci) {
    super(bahanUtama, berat);
    this.jumlahLaci = jumlahLaci;
  }

  public int getJumlahLaci() {
    return this.jumlahLaci;
  }

  @Override
  public String getNamaProduk() {
    return "Meja biasa";
  }

}
