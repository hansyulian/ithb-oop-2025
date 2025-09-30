package minisia.controllers;

import java.util.List;

import minisia.database.Database;
import minisia.models.Jurusan;
import minisia.repository.JurusanRepository;
import minisia.utils.Input;

public class JurusanController {

  JurusanRepository jurusanRepository;

  public JurusanController() {
    jurusanRepository = new JurusanRepository(Database.connect());
  }

  public void handle() {
    do {
      printMenu();
    } while (handleInput());
  }

  public void printMenu() {
    System.out.println("");
    System.out.println("Menu jurusan:");
    System.out.println("1. Lihat daftar jurusan");
    System.out.println("2. Tambah jurusan");
    System.out.println("3. Edit jurusan");
    System.out.println("4. Hapus jurusan");
    System.out.println("0. Keluar");
  }

  public boolean handleInput() {
    int input = Input.readInt();
    switch (input) {
      case 1 -> {
        try {
          List<Jurusan> records = jurusanRepository.findAll();
          for (Jurusan record : records) {
            System.out.println(record);
          }
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return true;
        }
      }
      case 2 -> {
        return true;
      }
      case 3 -> {
        return true;
      }
      case 4 -> {
        return true;
      }
      default -> {
        return false;
      }
    }
  }
}
