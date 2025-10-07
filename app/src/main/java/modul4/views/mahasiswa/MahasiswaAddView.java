package modul4.views.mahasiswa;

import modul4.controllers.MahasiswaController;
import modul4.util.CLIUtil;

public class MahasiswaAddView {
  private MahasiswaController mahasiswaController;

  public MahasiswaAddView() {
    this.mahasiswaController = new MahasiswaController();
  }

  public void render() {
    System.out.println("Masukkan NIM");
    String nim = CLIUtil.getString();
    System.out.println("Masukkan Kode Jurusan");
    String kodeJurusan = CLIUtil.getString();
    System.out.println("Masukkan Nama");
    String nama = CLIUtil.getString();
    System.out.println("Masukkan Tempat Lahir");
    String tempatLahir = CLIUtil.getString();
    System.out.println("Masukkan Tanggal Lahir");
    String tanggalLahir = CLIUtil.getString();
    System.out.println("Masukkan Alamat");
    String alamat = CLIUtil.getString();
    System.out.println("Masukkan Telepon");
    String telepon = CLIUtil.getString();
    mahasiswaController.add(nim, kodeJurusan, nama, tempatLahir, tanggalLahir, alamat, telepon);
  }

}
