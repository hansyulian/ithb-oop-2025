package teori9exception;

class HansException extends Exception {
  public HansException(String message) {
    super("From Hans Exception: " + message);
  }
}

class WhatIsException extends Exception {
  public WhatIsException(String message) {
    super("From WhatIsException: " + message);
  }
}

public class Teori9d5MultiCatch {

  public static void main(String[] args) {
    int i = 20;
    try {
      System.out.println(1);
      if (i == 10) {
        throw new HansException("Test exception");
      }
      System.out.println(11);
      if (i == 20) {
        throw new WhatIsException("what");
      }
      System.out.println(2);
    } catch (WhatIsException e) {
      System.out.println(33);
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println(44);
      System.out.println(e.getMessage());
    }
    System.out.println(5);
  }
}
