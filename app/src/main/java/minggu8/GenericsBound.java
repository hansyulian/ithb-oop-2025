package minggu8;

import java.util.List;

public class GenericsBound {
  class Generation0 {
    int generationValue;
  }

  class Generation1 extends Generation0 {
  };

  class Generation2 extends Generation1 {
  };

  class Generation3 extends Generation2 {
    public int getGenerationValue() {
      return this.generationValue;
    }
  };

  class Generation3a extends Generation2 {
  };

  class Generation41 extends Generation3 {
  };

  class Generation42 extends Generation3 {
  };

  class Generation4a extends Generation3a {
  };

  class GenerationPrinter {
    public static void printAll(List<? extends Generation3> list) {
      for (int i = 0; i < list.size(); i++) {
        Object item = list.get(i);
        System.out.println(item);
      }
    }
  }

  public static void main(String[] args) {
    // test here
    // List<Generation0> generation0List = new ArrayList<>();
    // GenerationPrinter.printAll(generation0List);
    // List<Generation1> generation1List = new ArrayList<>();
    // GenerationPrinter.printAll(generation1List);
    // List<Generation2> generation2List = new ArrayList<>();
    // GenerationPrinter.printAll(generation2List);
    // List<Generation3> generation3List = new ArrayList<>();
    // GenerationPrinter.printAll(generation3List);
    // List<Generation3a> generation3aList = new ArrayList<>();
    // GenerationPrinter.printAll(generation3aList);
    // List<Generation41> generation41List = new ArrayList<>();
    // GenerationPrinter.printAll(generation41List);
    // List<Generation42> generation42List = new ArrayList<>();
    // GenerationPrinter.printAll(generation42List);
    // List<Generation4a> generation4aList = new ArrayList<>();
    // GenerationPrinter.printAll(generation4aList);
  }
}
