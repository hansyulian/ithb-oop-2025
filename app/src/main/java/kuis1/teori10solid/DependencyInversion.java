package teori10solid;

import java.util.List;

interface IEmailSender {
  void send(String email, String subject, String content);
}

class GmailEmailSender implements IEmailSender {
  @Override
  public void send(String email, String subject, String content) {
    // send email
  }
}

class MockEmailSender implements IEmailSender {
  @Override
  public void send(String email, String subject, String content) {
    System.out.println("email sent");
  }
}

interface IUserController {
  void save();
}

class DatabaseUserController implements IUserController {
  IEmailSender emailSender;

  public DatabaseUserController(IEmailSender emailSender) {
    this.emailSender = emailSender;
  }

  @Override
  public void save() {
    // connect database
    // insert
  }
}

class MemoryUserController implements IUserController {
  List<Integer> users;

  @Override
  public void save() {
    users.add(1);
    // real save
  }
}

class UserView {
  private IUserController userController;

  public UserView(IUserController userController) {
    this.userController = userController;
  }

  public void onSave() {
    this.userController.save();
  }
}

class MahasiswaView {

  // i just care about save function, let the parent class provide the
  // implementation
  private IUserController userController;

  public MahasiswaView() {
    this.userController = new MemoryUserController();
    ;
  }

  public void onSave() {
    this.userController.save();
  }
}

public class DependencyInversion {

  public static void main(String[] args) {
    boolean isDevelopmentMode = true;
    IEmailSender emailSender = isDevelopmentMode ? new MockEmailSender() : new GmailEmailSender();
    IUserController userController = new DatabaseUserController(emailSender);
    UserView userView = new UserView(userController);
    MahasiswaView mahasiswaView = new MahasiswaView();
  }

}
