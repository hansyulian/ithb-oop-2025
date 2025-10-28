package teori9exception;

public class Teori9d2Exception {

  int value = 10;

  void method1(String label) throws Exception {
    String newLabel = label + " / 1";
    System.out.println(newLabel + " +");
    method2(newLabel);
    System.out.println(newLabel + " -");
  }

  void method2(String label) throws Exception {
    String newLabel = label + " / 2";
    System.out.println(newLabel + " +");
    method3(newLabel);
    System.out.println("check");
    if (value == 10) {
      throw new Exception("test method 2");
    }
    System.out.println(newLabel + " -");
  }

  void method3(String label) throws Exception {
    String newLabel = label + " / 3";
    System.out.println(newLabel + " +");
    if (value == 10) {
      throw new Exception("test method 3");
    }
    System.out.println(newLabel + " -");
  }

  public Teori9d2Exception() throws Exception {
    method1("r");
  }

  public static void main(String[] args) throws Exception {
    new Teori9d2Exception();
  }
}
