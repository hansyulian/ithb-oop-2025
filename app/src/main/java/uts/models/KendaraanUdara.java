package uts.models;

import uts.models.enums.BahanBakar;

public abstract class KendaraanUdara extends Kendaraan {

  public KendaraanUdara(String nama, int kapasitasOrang) {
    super(nama, kapasitasOrang, BahanBakar.AVTUR);
  }

}
