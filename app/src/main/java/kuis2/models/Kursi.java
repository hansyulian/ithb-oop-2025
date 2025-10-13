package kuis2.models;

public class Kursi extends Furnitur {
  private boolean adaSandaran;

  public Kursi(BahanUtama bahanUtama, double berat, boolean adaSandaran) {
    super(bahanUtama, berat);
    this.adaSandaran = adaSandaran;
  }

  public boolean getAdaSandaran() {
    return this.adaSandaran;
  }

  @Override
  public String getNamaProduk() {
    return "Kursi biasa";
  }

}
