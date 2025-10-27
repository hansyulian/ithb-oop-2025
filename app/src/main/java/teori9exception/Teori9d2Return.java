package teori9exception;

public class Teori9d2Return {

  int value = 10;

  void method1(String label) {
    String newLabel = label + " / 1";
    System.out.println(newLabel + " +");
    method2(newLabel);
    System.out.println(newLabel + " -");
  }

  void method2(String label) {
    String newLabel = label + " / 2";
    System.out.println(newLabel + " +");
    method3(newLabel);
    if (value == 10) {
      return;
    }
    System.out.println(newLabel + " -");
  }

  void method3(String label) {
    String newLabel = label + " / 3";
    System.out.println(newLabel + " +");
    if (value == 10) {
      return;
    }
    System.out.println(newLabel + " -");
  }

  public Teori9d2Return() {
    method1("r");
    method2("r");
    method3("r");
  }

  public static void main(String[] args) {
    new Teori9d2Return();
  }
}
