package hswpack.components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HTextBox extends HPanel {
  private JLabel label;
  private JTextField textField;

  public HTextBox(String label) {
    this(label, false);
  }

  public HTextBox(String label, boolean isPassword) {
    super();
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.label = new JLabel(label);
    this.textField = isPassword ? new JPasswordField(20) : new JTextField(20);
    this.add(this.label);
    this.label.setAlignmentX(Component.LEFT_ALIGNMENT);

    this.add(this.textField);
    this.textField.setAlignmentX(Component.LEFT_ALIGNMENT);
    this.textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));

    this.setBorder(new EmptyBorder(0, 0, 10, 0));
    this.setMaximumSize(new Dimension(Integer.MAX_VALUE, this.getPreferredSize().height));
    this.setAlignmentX(Component.LEFT_ALIGNMENT);
  }

  @Override
  public String getDebugLabelPrefix() {
    return "HTextBox";
  }
}
