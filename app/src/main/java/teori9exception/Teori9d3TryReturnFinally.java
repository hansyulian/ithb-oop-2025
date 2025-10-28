package teori9exception;

public class Teori9d3TryReturnFinally {

  static int fn(int i) {
    try {
      System.out.println(1);
      if (i == 10) {
        return 10;
      }
      System.out.println(1 / 0);
      System.out.println(2);
    } catch (Exception e) {
      System.out.println("080306");
    } finally {
      System.out.println(3);
    }
    System.out.println(4); // unreachable
    return 0;
  }

  public static void main(String[] args) {
    System.out.println("Result: " + fn(100));
  }
}
