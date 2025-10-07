package modul4.views;

import kuis1.util.CLIUtil;
import modul4.views.mahasiswa.MahasiswaView;

public class MenuView {
  private MahasiswaView mahasiswaView;

  public MenuView() {
    this.mahasiswaView = new MahasiswaView();
  }

  public void render() {
    System.out.println("Menu SIA:");
    System.out.println("1. Menu Mahasiswa");

    this.handleMenuInput();
  }

  private void handleMenuInput() {
    int menuInput = CLIUtil.getInt();

    switch (menuInput) {
      case 1: {
        this.mahasiswaView.render();
        break;
      }
    }
  }

}
