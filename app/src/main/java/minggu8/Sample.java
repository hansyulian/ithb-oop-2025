package minggu8;

import java.util.ArrayList;
import java.util.List;

public class Sample {

  class Generation0 {
    public int value;
  }

  class Generation1 extends Generation0 {
  }

  class Generation2 extends Generation1 {
  }

  class Generation3 extends Generation2 {
  }

  class Generation3a extends Generation2 {
  }

  class Generation4 extends Generation3 {
  }

  class Generation41 extends Generation3 {
  }

  class Generation4a extends Generation3a {
  }

  class GenerationUtil {
    public static void printAll(List<? extends Generation3> list) {
      for (Generation3 g : list) {
        System.out.println(g.value);
      }
    }
  }

  public static void main(String[] args) {
    // List<Generation2> listGeneration2 = new ArrayList<>();
    // GenerationUtil.printAll(listGeneration2);
    List<Generation4> listGeneration4 = new ArrayList<>();
    GenerationUtil.printAll(listGeneration4);
  }

}
