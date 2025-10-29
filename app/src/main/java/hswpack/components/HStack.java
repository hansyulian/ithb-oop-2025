package hswpack.components;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class HStack extends HPanel {
  private int width = 0;

  public HStack() {
    super();
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.selfAlignCenter();
  }

  public HStack(int width) {
    this();
    this.width = width;
  }

  public void addGap(int size) {
    this.add(Box.createVerticalStrut(size));
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension preferredSize = super.getPreferredSize();
    if (width > 0) {
      preferredSize.width = width;
    }
    return preferredSize;
  }

  @Override
  public String getDebugLabelPrefix() {
    return "HStack";
  }

}
