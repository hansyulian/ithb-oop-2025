package modul4.controllers;

import modul4.models.Mahasiswa;
import modul4.repository.MahasiswaRepository;

public class MahasiswaController {

  private MahasiswaRepository mahasiswaRepository;

  public MahasiswaController() {
    mahasiswaRepository = new MahasiswaRepository();
  }

  public void add(String nim, String kodeJurusan, String nama, String tempatLahir, String tanggalLahir, String alamat,
      String telepon) {
    mahasiswaRepository.add(nim, kodeJurusan, nama, tempatLahir, tanggalLahir, alamat, telepon);
  };

  public void delete() {
  };

  public void update() {
  };

  public Mahasiswa[] findAll() {
    return new Mahasiswa[0];
  };

  public Mahasiswa get(String nim) {
    return null;
  };
}
