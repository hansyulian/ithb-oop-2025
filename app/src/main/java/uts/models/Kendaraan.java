package uts.models;

import uts.models.enums.BahanBakar;

public abstract class Kendaraan {
  private int kapasitasOrang;
  private String nama;
  private BahanBakar bahanBakar;

  public Kendaraan(String nama, int kapasitasOrang, BahanBakar bahanBakar) {
    this.bahanBakar = bahanBakar;
    this.kapasitasOrang = kapasitasOrang;
    this.nama = nama;
  }

  public int getKapasitasOrang() {
    return this.kapasitasOrang;
  }

  public String getNama() {
    return this.nama;
  }

  public BahanBakar getBahanBakar() {
    return this.bahanBakar;
  }

  public String getDetail() {
    return this.nama + ", kapasitas orang: " + this.kapasitasOrang;
  };

}
