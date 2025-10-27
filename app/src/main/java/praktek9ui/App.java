package praktek9ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class TextBox extends JPanel {
  private JLabel label;
  private JTextField textField;

  public TextBox(String label, int x, int y) {
    this(label, x, y, false);
  }

  public TextBox(String label, int x, int y, boolean isPassword) {
    super();
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.label = new JLabel(label);
    this.textField = isPassword ? new JPasswordField(20) : new JTextField(20);
    this.add(this.label);
    this.add(this.textField);
    this.setBounds(x, y, 400, 50);

    this.label.setAlignmentX(Component.LEFT_ALIGNMENT);
    this.textField.setAlignmentX(Component.LEFT_ALIGNMENT);
  }

}

public class App {

  public static void main(String[] args) {
    String appName = "Simple Swing App";
    int width = 600;
    int height = 400;

    JFrame frame = new JFrame(appName);
    //

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(null);

    JButton loginButton = new JButton("Login");

    loginButton.setBounds(250, 180, 100, 20);
    mainPanel.add(new TextBox("Email", 100, 50));
    mainPanel.add(new TextBox("Password", 100, 100, true));
    mainPanel.add(loginButton);
    frame.add(mainPanel);

    //
    frame.setSize(width, height);
    frame.setBackground(new Color(255, 0, 0));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}
