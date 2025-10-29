package hswpack.components;

import java.awt.Component;

import javax.swing.JFrame;

public class HFrame extends JFrame {

  public HFrame(String title) {
    this(title, 800, 600);
  }

  public HFrame(String title, int width, int height) {
    super(title);
    this.setSize(width, height);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null); // center frame
  }

  public <T extends Component> T addH(T component) {
    super.add(component);
    return component;
  }
}
