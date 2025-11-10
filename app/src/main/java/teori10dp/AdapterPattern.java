package teori10dp;

class OftenlyBreakingChangesLibrary {
  public double calculateArea(double length, double width) {
    return length * width * 4;
  }
}

class AdapterPattern {

  class AdapterForTheIdiot {
    private OftenlyBreakingChangesLibrary theIdiot;

    public AdapterForTheIdiot(OftenlyBreakingChangesLibrary theIdiot) {
      this.theIdiot = theIdiot;
    }

    public int calculateArea(int length, int width) {
      return (int) theIdiot.calculateArea(length, width) / 4;
    }

  }

  public AdapterPattern() {

    AdapterForTheIdiot library = new AdapterForTheIdiot(new OftenlyBreakingChangesLibrary());
    System.out.println(library.calculateArea(10, 20));
    System.out.println(library.calculateArea(20, 20));
    System.out.println(library.calculateArea(30, 20));
  }

  public static void main(String[] args) {
    new AdapterPattern();
  }
}
