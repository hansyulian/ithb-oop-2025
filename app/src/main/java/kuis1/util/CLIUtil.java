package kuis1.util;

import java.util.Scanner;

public class CLIUtil {
  private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  public static int getInt() {
    return scanner.nextInt();
  }

}
