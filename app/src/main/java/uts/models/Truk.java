package uts.models;

import uts.models.enums.BahanBakar;
import uts.models.interfaces.Kargoable;

public class Truk extends KendaraanDarat implements Kargoable {

  public Truk(String nama, int jumlahRoda) {
    super(nama, 3, BahanBakar.DIESEL, jumlahRoda);
  }

  @Override
  public void loadKargo() {
    System.out.println("Truk memasukkan kargo");
  }

  @Override
  public void unloadKargo() {
    System.out.println("Truk mengeluarkan kargo");
  }

  @Override
  public String getDetail() {
    return "Truk " + super.getDetail();
  }
}
