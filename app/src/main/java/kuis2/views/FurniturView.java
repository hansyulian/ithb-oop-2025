package kuis2.views;

import java.util.List;

import kuis1.util.CLIUtil;
import kuis2.controllers.FurniturController;
import kuis2.models.BahanUtama;
import kuis2.models.Furnitur;

public class FurniturView {
  FurniturController furniturController;

  public FurniturView() {
    this.furniturController = new FurniturController();
  }

  public void render() {
    int menu = this.getMenuInput();
    while (menu != 0) {
      this.handleMenu(menu);
      menu = this.getMenuInput();
    }
  }

  private int getMenuInput() {
    System.out.println("Menu:");
    System.out.println("1. Tambah furnitur");
    System.out.println("2. Tampilkan semua");
    System.out.println("0. Keluar");
    System.out.print("Pilihanmu: ");
    return CLIUtil.getInt();
  }

  private void handleMenu(int menu) {
    switch (menu) {
      case 1:
        int menuFurnitur = this.getMenuFurnitur();
        this.handleMenuFurnitur(menuFurnitur);
        break;
      case 2:
        List<Furnitur> furnitures = this.furniturController.getAll();
        for (int i = 0; i < furnitures.size(); i++) {
          Furnitur furnitur = furnitures.get(i);
          System.out.println((i + 1) + ". " + furnitur.getNamaProduk() + " " + furnitur.getBahanUtamaString()
              + " Berat " + furnitur.getBerat() + "kg");
        }
        break;
    }
  }

  private int getMenuFurnitur() {
    System.out.println("Menu:");
    System.out.println("1. Meja");
    System.out.println("2. Kursi");
    System.out.println("3. Meja lipat");
    System.out.println("4. Sofa");
    System.out.println("0. Keluar");
    System.out.print("Pilihanmu: ");
    return CLIUtil.getInt();
  }

  private void handleMenuFurnitur(int menu) {
    BahanUtama bahanUtama = getMenuBahanUtama();
    System.out.println("Masukkan berat:");
    double berat = CLIUtil.getDouble();
    switch (menu) {
      case 1:
        System.out.println("Masukkan jumlah laci:");
        int jumlahLaci = CLIUtil.getInt();
        furniturController.addFurnitur(bahanUtama, berat, jumlahLaci);
        break;
      case 2:
        System.out.println("Ada Sandaran? 1 = Ya 0 = Tidak");
        int input = CLIUtil.getInt();
        furniturController.addFurnitur(bahanUtama, berat, input == 1);
        break;
      case 3:
        furniturController.addFurnitur(bahanUtama, berat);
        break;
      case 4:
        System.out.println("Jumlah dudukan");
        int jumlahDudukan = CLIUtil.getInt();
        furniturController.addFurnitur(bahanUtama, berat, jumlahDudukan, true);
        break;
    }
  }

  private BahanUtama getMenuBahanUtama() {
    System.out.println("1. Besi");
    System.out.println("2. Kayu");
    System.out.println("3. Plastik");
    int pilihan = CLIUtil.getInt();
    switch (pilihan) {
      case 1:
        return BahanUtama.BESI;
      case 2:
        return BahanUtama.KAYU;
      case 3:
        return BahanUtama.PLASTIK;
    }
    return BahanUtama.BESI;
  }
}
