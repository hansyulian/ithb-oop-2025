package uts.models;

public class Helikopter extends KendaraanUdara {
  private int jumlahBalingBaling;

  public Helikopter(String nama, int kapasitasOrang, int jumlahBalingBaling) {
    super(nama, kapasitasOrang);
    this.jumlahBalingBaling = jumlahBalingBaling;
  }

  public int getJumlahBalingBaling() {
    return this.jumlahBalingBaling;
  }

  @Override
  public String getDetail() {
    return "Helikopter " + super.getDetail() + ", Jumlah Baling-Baling: " + this.jumlahBalingBaling;
  }

}
