package praktek10generic.models;

import praktek10generic.models.enums.TipeStaff;

public class DosenHonorer extends Staff {
  public double honorPerSks;

  public DosenHonorer(String nik, String nama, TipeStaff tipe, double honorPerSks) {
    super(nik, nama, tipe);
    this.honorPerSks = honorPerSks;
  }

  @Override
  public String toString() {
    return "DosenHonorer{" +
        "nik='" + nik + '\'' +
        ", nama='" + nama + '\'' +
        ", tipe=" + tipe +
        ", honorPerSks=" + honorPerSks +
        '}';
  }
}
