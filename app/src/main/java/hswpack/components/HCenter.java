package hswpack.components;

import java.awt.BorderLayout;
import java.awt.Component;

public class HCenter extends HPanel {

  public HCenter() {
    super();
    this.setLayout(new BorderLayout());
  }

  public <T extends Component> T addH(T component) {
    super.add(component, BorderLayout.CENTER);
    return component;
  }

  @Override
  public String getDebugLabelPrefix() {
    return "HCenter";
  }
}
