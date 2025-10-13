package kuis2.models;

public abstract class Furnitur {
  private BahanUtama bahanUtama;
  private double berat;

  public Furnitur(BahanUtama bahanUtama, double berat) {
    this.bahanUtama = bahanUtama;
    this.berat = berat;
  }

  public double getBerat() {
    return this.berat;
  }

  public BahanUtama getBahanUtama() {
    return this.bahanUtama;
  }

  public String getBahanUtamaString() {
    switch (this.bahanUtama) {
      case KAYU:
        return "Kayu";
      case BESI:
        return "Besi";
      case PLASTIK:
        return "Plastik";
    }
    return "Entah";
  }

  public abstract String getNamaProduk();
}
