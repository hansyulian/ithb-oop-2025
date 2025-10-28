package teori9exception;

class UserForm {
  String nama;
  String password;
  String confirmPassword;
}

public class Teori9d6Validation {

  static void validateForm(UserForm form) throws Exception {
    if (form.nama == null || form.nama.isEmpty()) {
      throw new Exception("Nama tidak boleh kosong");
    }
    if (form.password == null || form.password.isEmpty()) {
      throw new Exception("Password tidak boleh kosong");
    }
    if (!form.password.equals(form.confirmPassword)) {
      throw new Exception("Password dan Confirm Password tidak sesuai");
    }
  }

  static void createUser(UserForm form) throws Exception {
    validateForm(form);
    // insert database
    // return
  }

  static void updateUser(String userId, UserForm form) throws Exception {
    validateForm(form);
    // find user from database

  }

  public static void main(String[] args) {
    UserForm form = new UserForm();
    form.nama = "Hans";
    form.password = "12345";
    form.confirmPassword = "1234";
  }
}
