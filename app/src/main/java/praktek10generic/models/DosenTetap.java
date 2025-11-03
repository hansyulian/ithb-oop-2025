package praktek10generic.models;

import praktek10generic.models.enums.TipeStaff;

public class DosenTetap extends Staff {
  public double gajiPokok;

  public DosenTetap(String nik, String nama, TipeStaff tipe, double gajiPokok) {
    super(nik, nama, tipe);
    this.gajiPokok = gajiPokok;
  }

  @Override
  public String toString() {
    return "DosenTetap{" +
        "nik='" + nik + '\'' +
        ", nama='" + nama + '\'' +
        ", tipe=" + tipe +
        ", gajiPokok=" + gajiPokok +
        '}';
  }
}
