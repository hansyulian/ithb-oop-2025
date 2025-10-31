package example1presensi;

public class PresensiSummary {
  private String nim;
  private String kodeMatakuliah;
  private int hadir;
  private int alpha;
  private int sakit;

  public PresensiSummary(String nim, String kodeMatakuliah, int hadir, int alpha, int sakit) {
    this.nim = nim;
    this.kodeMatakuliah = kodeMatakuliah;
    this.hadir = hadir;
    this.alpha = alpha;
    this.sakit = sakit;
  }

  public String getNim() {
    return nim;
  }

  public String getKodeMatakuliah() {
    return kodeMatakuliah;
  }

  public int getHadir() {
    return hadir;
  }

  public int getAlpha() {
    return alpha;
  }

  public int getSakit() {
    return sakit;
  }

  public int getTotal() {
    return hadir + alpha + sakit;
  }

  @Override
  public String toString() {
    return nim + " " + kodeMatakuliah + " " + hadir + " " + alpha + " " + sakit + " " + getTotal();
  }
}
