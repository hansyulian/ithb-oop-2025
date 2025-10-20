package uts.views;

import uts.controllers.KendaraanController;
import uts.models.Kendaraan;
import uts.models.enums.BahanBakar;
import uts.utils.CLIUtils;

public class KendaraanView {
  private KendaraanController kendaraanController;

  public KendaraanView() {
    this.kendaraanController = new KendaraanController();
    this.kendaraanController.tambah("CRV", 5, BahanBakar.BENSIN);
    this.kendaraanController.tambah("Fortuner", 5, BahanBakar.DIESEL);
    this.kendaraanController.tambah("Sampah", 10);
    this.kendaraanController.tambah("SU57", 1, 4, true);
    this.kendaraanController.tambah("A380", 300, 22, false);
    this.kendaraanController.tambah("Apache", 2, 8);
  }

  public void render() {
    this.printMenu();
    int menu = CLIUtils.getInt();
    while (menu != 0) {
      switch (menu) {
        case 1:
          this.handleTambahKendaraan();
          break;
        case 2:
          this.handlePrintKendaraan();
          break;
        case 3:
          this.handleSortKendaraan();
          break;
        case 0:
          return;
      }
      this.printMenu();
      menu = CLIUtils.getInt();
    }
  }

  private void printMenu() {
    System.out.println("Menu:");
    System.out.println("1. Tambah kendaraan");
    System.out.println("2. Tampilkan semua kendaraan");
    System.out.println("3. Urutkan kendaraan berdasarkan kapasitas");
    System.out.println("0. Keluar");
  }

  private void handleTambahKendaraan() {
    int tipe = CLIUtils.askForInt("Masukkan tipe kendaraan: 1 = Mobil, 2 = Truk, 3 = Helikopter, 4 = Pesawat");
    if (tipe > 4 || tipe < 1) {
      System.out.println("Tipe kendaraan tidak valid");
      return;
    }
    CLIUtils.getString();
    String nama = CLIUtils.askForString("Masukkan nama kendaraan: ");
    switch (tipe) {
      case 1:
        int bahanBakarIndex = CLIUtils.askForInt("Masukkan tipe bahan bakar mobil: 1 = bensin, 2 = diesel");
        if (bahanBakarIndex > 2 || bahanBakarIndex < 1) {
          System.out.println("Tipe bahan bakar tidak valid");
          return;
        }
        BahanBakar bahanBakar = bahanBakarIndex == 1 ? BahanBakar.BENSIN : BahanBakar.DIESEL;
        int kapasitas = CLIUtils.askForInt("Masukkan kapasitas mobil: ");
        this.kendaraanController.tambah(nama, kapasitas, bahanBakar);
        break;
      case 2:
        int jumlahRoda = CLIUtils.askForInt("Masukkan jumlah roda truk: ");
        this.kendaraanController.tambah(nama, jumlahRoda);
        break;
      case 3:
        int kapasitasHeli = CLIUtils.askForInt("Masukkan kapasitas heli: ");
        int jumlahBalingBaling = CLIUtils.askForInt("Masukkan jumlah baling-baling heli: ");
        this.kendaraanController.tambah(nama, kapasitasHeli, jumlahBalingBaling);
        break;
      case 4:
        int kapasitasPesawat = CLIUtils.askForInt("Masukkan kapasitas pesawat: ");
        int jumlahRodaPesawat = CLIUtils.askForInt("Masukkan jumlah roda pesawat: ");
        int indeksPesawatTempur = CLIUtils.askForInt("Apakah pesawat tempur? 0 = tidak, lainnya = ya");
        boolean pesawatTempur = indeksPesawatTempur == 0 ? false : true;
        this.kendaraanController.tambah(nama, kapasitasPesawat, jumlahRodaPesawat, pesawatTempur);
        break;
    }
  }

  private void handlePrintKendaraan() {
    var objects = this.kendaraanController.getDaftar();
    for (Kendaraan kendaraan : objects) {
      System.out.println(kendaraan.getDetail());
    }
  }

  private void handleSortKendaraan() {
    this.kendaraanController.sortByKapasitas();
    System.out.println("Kendaraan telah diurutkan");
  }
}
