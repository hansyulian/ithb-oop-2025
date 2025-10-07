package modul4.models;

public class Staff extends User {
  private String nik;

  public Staff(String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon) {
    super(UserType.STAFF, nama, tempatLahir, tanggalLahir, alamat, telepon);
    this.nik = nik;
  }

  public String getNik() {
    return nik;
  }
}
