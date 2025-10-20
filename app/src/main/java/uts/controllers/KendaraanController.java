package uts.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import uts.models.Helikopter;
import uts.models.Kendaraan;
import uts.models.Mobil;
import uts.models.Pesawat;
import uts.models.Truk;
import uts.models.enums.BahanBakar;

public class KendaraanController {
  private List<Kendaraan> records;

  public KendaraanController() {
    this.records = new ArrayList<>();
  }

  public void sortByKapasitas() {
    this.records.sort(new Comparator<Kendaraan>() {
      @Override
      public int compare(Kendaraan o1, Kendaraan o2) {
        return o1.getKapasitasOrang() - o2.getKapasitasOrang();
      }
    });
  }

  public List<Kendaraan> getDaftar() {
    return this.records;
  }

  public void tambah(String nama, int kapasitasOrang, int jumlahBalingBaling) {
    records.add(new Helikopter(nama, kapasitasOrang, jumlahBalingBaling));
  }

  public void tambah(String nama, int kapasitasOrang, BahanBakar bahanBakar) {
    records.add(new Mobil(nama, kapasitasOrang, bahanBakar));
  }

  public void tambah(String nama, int kapasitasOrang, int jumlahRoda, boolean pesawatTempur) {
    records.add(new Pesawat(nama, kapasitasOrang, jumlahRoda, pesawatTempur));
  }

  public void tambah(String nama, int jumlahRoda) {
    records.add(new Truk(nama, jumlahRoda));
  }
}
