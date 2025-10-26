package minggu8;

public class SampleGeneric {

  interface Doubleable {
    public double getDouble();
  }

  class SampleDataChild extends SampleDataStructure {

    public SampleDataChild(String string, double value) {
      super(string, value);
    }
  }

  class SampleDataStructure implements Doubleable {
    private String name;
    private double value;

    public SampleDataStructure(String string, double value) {
      this.name = string;
      this.value = value;
    }

    public String getName() {
      return this.name;
    }

    public double getValue() {
      return this.value;
    }

    @Override
    public double getDouble() {
      return this.value * 2;
    }
  }

  class Box<T extends Doubleable> {
    private T value;

    public Box(T value) {
      this.value = value;
    }

    public T get() {
      return value;
    }

    public void set(T value) {
      this.value = value;
    }

    public double getDoubledValue() {
      return this.value.getDouble();
    }
  }

  class Box2 {
    private Doubleable value;

    public Box2(Doubleable value) {
      this.value = value;
    }

    public Doubleable get() {
      return value;
    }

    public void set(Doubleable value) {
      this.value = value;
    }

    public double getDoubledValue() {
      return this.value.getDouble();
    }
  }

  public SampleGeneric() {
    Box<SampleDataStructure> box = new Box<>(new SampleDataStructure("Hans", 0));
    Doubleable x1 = box.get(); // x1 SampleDataStructure
    SampleDataStructure x2 = box.get(); // x2 SampleDataStructure
    // Box2 box2 = new Box2(new SampleDataStructure("Hans", 0));
    // Doubleable y1 = box2.get(); // y1 Doubleable
    // SampleDataStructure y2 = box2.get(); // y2 Doubleable
  }

  public static void main(String[] args) {
    new SampleGeneric();
  }

}
