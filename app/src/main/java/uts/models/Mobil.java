package uts.models;

import uts.models.enums.BahanBakar;

public class Mobil extends KendaraanDarat {

  public Mobil(String nama, int kapasitasOrang, BahanBakar bahanBakar) {
    super(nama, kapasitasOrang, bahanBakar, 4);
  }

  @Override
  public String getDetail() {
    return "Mobil " + super.getDetail();
  }
}
