package playground;

import java.util.Scanner;

public class Util {
  private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  public static String getString() {
    return scanner.nextLine();
  }

  public static int getInt() {
    return scanner.nextInt();
  }

}
