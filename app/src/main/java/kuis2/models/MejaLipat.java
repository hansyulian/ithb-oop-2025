package kuis2.models;

public class MejaLipat extends Meja implements Lipatable {

  public MejaLipat(BahanUtama bahanUtama, double berat) {
    super(bahanUtama, berat, 0);
  }

  @Override
  public String getNamaProduk() {
    return "Meja lipat";
  }

  @Override
  public String lipat() {
    return "Lipat kaki kiri, lipat kaki kanan";
  }

}
