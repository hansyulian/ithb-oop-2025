package teori9exception;

public class Teori9d3TryCatchFinally {

  public static void main(String[] args) {
    int i = 10;
    try {
      System.out.println(0);
      try {
        System.out.println(1);
        if (i == 10) {
          throw new Exception("Test exception");
        }
        System.out.println(2);
      } catch (Exception e) {
        System.out.println(3);
        System.out.println(e.getMessage());
        if (i == 10) {
          throw new Exception("Re-throwing exception");
        }
        System.out.println(4);
      } finally {
        System.out.println("finally");
      }
      System.out.println(44);
    } catch (Exception e) {
      System.out.println(51);
      System.out.println(e.getMessage());
      System.out.println(52);
    }
    System.out.println(5);
  }
}
