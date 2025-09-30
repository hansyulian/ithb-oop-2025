package minisia.controllers;

import minisia.utils.Input;

public class MenuController {

  private JurusanController jurusanController;
  private MatakuliahController matakuliahController;
  private MahasiswaController mahasiswaController;

  public MenuController() {
    jurusanController = new JurusanController();
    matakuliahController = new MatakuliahController();
    mahasiswaController = new MahasiswaController();
  }

  public void handle() {
    do {
      printMenu();
    } while (handleInput());
  }

  public boolean handleInput() {
    int input = Input.readInt();
    switch (input) {
      case 1 -> {
        jurusanController.handle();
        return true;
      }
      case 2 -> {
        // matakuliahController.start();
        return true;
      }
      case 3 -> {
        // mahasiswaController.start();
        return true;
      }
      default -> {
        return false;
      }
    }
  }

  public void printMenu() {
    System.out.println("");
    System.out.println("Menu utama: ");
    System.out.println("1. Menu jurusan");
    System.out.println("2. Menu mata kuliah");
    System.out.println("3. Menu mahasiswa");
    System.out.println("0. Keluar ");
  }
}
