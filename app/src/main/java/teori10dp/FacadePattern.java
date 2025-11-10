package teori10dp;

import java.util.UUID;

public class FacadePattern {

  public static String getUuid() {
    return UUID.randomUUID().toString();
  }

  public static void main() {

    String id = getUuid();
    System.out.println(id);

    String id2 = getUuid();
    System.out.println(id2);

    String id3 = getUuid();
    System.out.println(id3);
  }

}
