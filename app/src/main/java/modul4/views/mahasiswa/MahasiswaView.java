package modul4.views.mahasiswa;

import kuis1.util.CLIUtil;

public class MahasiswaView {
  private MahasiswaAddView mahasiswaAddView;

  public MahasiswaView() {
    this.mahasiswaAddView = new MahasiswaAddView();
  }

  public void render() {
    System.out.println("Menu Mahasiswa:");
    System.out.println("1. Lihat daftar mahasiswa");
    System.out.println("2. Tambah mahasiswa");
    System.out.println("3. Edit mahasiswa");
    System.out.println("4. Hapus mahasiswa");
    System.out.println("0. Keluar");
    handleMenuInput();
  }

  private void handleMenuInput() {
    int menuInput = CLIUtil.getInt();
    switch (menuInput) {
      case 2:
        this.mahasiswaAddView.render();
        break;
    }
  }

}
