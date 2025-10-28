package praktek9ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Praktek9UIWithLayout {

  class TextBox extends JPanel {
    private JLabel label;
    private JTextField textField;

    public TextBox(String label) {
      this(label, false);
    }

    public TextBox(String label, boolean isPassword) {
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

  }

  public Praktek9UIWithLayout() {

    String appName = "Simple Swing App";
    int width = 600;
    int height = 400;

    JFrame frame = new JFrame(appName);
    //

    JPanel mainPanel = new JPanel();
    frame.add(mainPanel);
    JPanel outerWrapper = new JPanel();
    outerWrapper.setLayout(new BoxLayout(outerWrapper, BoxLayout.Y_AXIS));
    outerWrapper.setBorder(new EmptyBorder(50, 0, 0, 0));

    JPanel formWrapperPanel = new JPanel();
    formWrapperPanel.setLayout(new BoxLayout(formWrapperPanel, BoxLayout.Y_AXIS));
    formWrapperPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // center form block

    JPanel formInnerWrapperPanel = new JPanel();
    formInnerWrapperPanel.setLayout(new BoxLayout(formInnerWrapperPanel, BoxLayout.Y_AXIS));
    formInnerWrapperPanel.setMaximumSize(new Dimension(400, Integer.MAX_VALUE));
    formInnerWrapperPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // center form block
    TextBox emailBox = new TextBox("Email");
    formInnerWrapperPanel.add(emailBox);

    TextBox passBox = new TextBox("Password", true);
    formInnerWrapperPanel.add(passBox);

    JPanel centerContainer = new JPanel();
    JButton loginButton = new JButton("Login");
    // loginButton.setAlignmentX(Component.CENTER_ALIGNMENT); // center button
    centerContainer.add(loginButton);
    formWrapperPanel.add(formInnerWrapperPanel);
    formWrapperPanel.add(centerContainer);

    outerWrapper.add(formWrapperPanel);
    mainPanel.add(outerWrapper);
    //
    frame.setSize(width, height);
    frame.setBackground(new Color(255, 0, 0));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    new Praktek9UIWithLayout();
  }
}
