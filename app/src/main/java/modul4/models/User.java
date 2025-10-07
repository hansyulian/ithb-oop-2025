package modul4.models;

public abstract class User {
  private String nama;
  private String tempatLahir;
  private String tanggalLahir;
  private String alamat;
  private String telepon;
  private UserType type;

  public User(UserType type, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon) {
    this.type = type;
    this.nama = nama;
    this.tempatLahir = tempatLahir;
    this.tanggalLahir = tanggalLahir;
    this.alamat = alamat;
    this.telepon = telepon;
  }

  public UserType getType() {
    return type;
  }

  public String getNama() {
    return nama;
  }

  public String getTempatLahir() {
    return tempatLahir;
  }

  public String getTanggalLahir() {
    return tanggalLahir;
  }

  public String getAlamat() {
    return alamat;
  }

  public String getTelepon() {
    return telepon;
  }

  public String getTempatTanggalLahir() {
    return tempatLahir + ", " + tanggalLahir;
  };
}
