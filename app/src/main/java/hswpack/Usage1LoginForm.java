package hswpack;

import hswpack.components.*;

public class Usage1LoginForm {

  public static void main(String[] args) {
    // HPanel.ENABLE_DEBUG = true;
    HFrame frame = new HFrame("Usage 1 Login Form", 800, 600);
    HPanel mainPanel = frame.addH(new HPanel());
    HStack formStack = mainPanel.addH(new HStack());
    formStack.setBorder(50, 0, 0, 0);
    HStack inputStack = formStack.addH(new HStack(400));
    HTextBox emailTextBox = inputStack.addH(new HTextBox("Email"));
    HTextBox passwordTextBox = inputStack.addH(new HTextBox("Password", true));
    formStack.addGap(20);
    HCenter buttonContainer = formStack.addH(new HCenter());
    HRow buttonInnerContainer = buttonContainer.addH(new HRow());
    buttonInnerContainer.addH(new HButton("Login"));
    buttonInnerContainer.addH(new HButton("Register"));
    frame.setVisible(true);
  }
}
