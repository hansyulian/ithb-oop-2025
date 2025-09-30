package kuis1;

import java.util.Scanner;

public class Util {
  private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  public static int getInt() {
    return scanner.nextInt();
  }

}
