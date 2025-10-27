package teori9exception;

public class Teori9d3TryCatch {
  public static void main(String[] args) {
    int i = 10;
    try {
      System.out.println(1);
      if (i == 10) {
        throw new Exception("Test exception");
      }
      System.out.println(2);
    } catch (Exception e) {
      System.out.println(3);
      System.out.println(e.getMessage());
      System.out.println(4);
    }
    System.out.println(5);
  }
}
