package teori9exception;

public class Teori9d3TryReturnFinally {

  static int fn() {
    try {
      System.out.println(1);
      return 10;
    } finally {
      System.out.println(3);
    }
    // System.out.println(4); // unreachable
  }

  public static void main(String[] args) {
    System.out.println("Result: " + fn());
  }
}
