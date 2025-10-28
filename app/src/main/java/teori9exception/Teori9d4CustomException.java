package teori9exception;

class Hans2Exception extends Exception {
  int type;

  public Hans2Exception(String message, int type) {
    super("From Hans Exception: " + message);
    this.type = type;
  }
}

public class Teori9d4CustomException {

  public static void main(String[] args) {
    int i = 10;
    try {
      System.out.println(1);
      if (i == 10) {
        throw new Hans2Exception("Test exception", 5);
      }
      System.out.println(2);
    } catch (Hans2Exception e) {
      System.out.println(3);
      System.out.println(e.getMessage());
      System.out.println("Exception type" + e.type);
      System.out.println(4);
    }
    System.out.println(5);
  }
}
