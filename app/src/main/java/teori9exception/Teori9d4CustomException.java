package teori9exception;

class HansException extends Exception {
  public HansException(String message) {
    super("From Hans Exception: " + message);
  }
}

public class Teori9d4CustomException {

  public static void main(String[] args) {
    int i = 10;
    try {
      System.out.println(1);
      if (i == 10) {
        throw new HansException("Test exception");
      }
      System.out.println(2);
    } catch (HansException e) {
      System.out.println(3);
      System.out.println(e.getMessage());
      System.out.println(4);
    }
    System.out.println(5);
  }
}
