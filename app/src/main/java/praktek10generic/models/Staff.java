package praktek10generic.models;

import praktek10generic.models.enums.TipeStaff;

public abstract class Staff {
  public String nik;
  public String nama;
  public TipeStaff tipe;

  public Staff(String nik, String nama, TipeStaff tipe) {
    this.nik = nik;
    this.nama = nama;
    this.tipe = tipe;
  }

}
