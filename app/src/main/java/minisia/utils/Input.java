package minisia.utils;

import java.util.Scanner;

public class Input {

  private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  public static String readLine() {
    return scanner.nextLine();
  }

  public static int readInt() {
    return scanner.nextInt();
  }

}
