package uts.models;

import uts.models.enums.BahanBakar;

public abstract class KendaraanDarat extends Kendaraan {
  private int jumlahRoda;

  public KendaraanDarat(String nama, int kapasitasOrang, BahanBakar bahanBakar, int jumlahRoda) {
    super(nama, kapasitasOrang, bahanBakar);
    this.jumlahRoda = jumlahRoda;
  }

  public int getJumlahRoda() {
    return this.jumlahRoda;
  }

  @Override
  public String getDetail() {
    return super.getDetail() + ", Jumlah Roda: " + this.jumlahRoda;
  }

}
