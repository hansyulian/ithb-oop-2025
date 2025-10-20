package uts.models;

import uts.models.interfaces.Kargoable;

public class Pesawat extends KendaraanUdara implements Kargoable {
  private int jumlahRoda;
  private boolean pesawatTempur;

  public Pesawat(String nama, int kapasitasOrang, int jumlahRoda, boolean pesawatTempur) {
    super(nama, kapasitasOrang);
    this.pesawatTempur = pesawatTempur;
    this.jumlahRoda = jumlahRoda;
  }

  public int getJumlahRoda() {
    return this.jumlahRoda;
  }

  public boolean isPesawatTempur() {
    return this.pesawatTempur;
  }

  @Override
  public String getDetail() {
    return "Pesawat " + super.getDetail() + ", Jumlah Roda: "
        + this.jumlahRoda;
  }

  @Override
  public void loadKargo() {
    System.out.println("Pesawat memasukkan kargo");
  }

  @Override
  public void unloadKargo() {
    System.out.println("Pesawat mengeluarkan kargo");
  }

}
