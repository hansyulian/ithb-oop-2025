package hswpack.components;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hswpack.utils.HSwingDebugUtil;

public class HPanel extends JPanel {
  public static boolean ENABLE_DEBUG = false;

  public HPanel() {
    super();
    if (ENABLE_DEBUG) {
      HSwingDebugUtil.debugVisual(this);
    }
  }

  public <T extends Component> T addH(T component) {
    super.add(component);
    return component;
  }

  public void setBorder(int top, int left, int bottom, int right) {
    super.setBorder(new EmptyBorder(top, left, bottom, right));
  }

  public void selfAlignCenter() {
    this.setAlignmentX(Component.CENTER_ALIGNMENT);
  }

  public String getDebugLabelPrefix() {
    return "HPanel";
  }
}
