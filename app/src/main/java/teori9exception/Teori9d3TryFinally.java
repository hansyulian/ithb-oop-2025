package teori9exception;

public class Teori9d3TryFinally {
  public static void main(String[] args) throws Exception {
    int i = 10;
    try {
      System.out.println(1);
      if (i == 10) {
        throw new Exception("Test exception");
      }
      System.out.println(2);
    } finally {
      System.out.println(3);
    }
    System.out.println(4);
  }
}
