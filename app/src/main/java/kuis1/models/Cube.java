package kuis1.models;

public class Cube extends Cuboid {

  public Cube(double side) {
    super(ObjectName.CUBE, side, side, side);
  }

  public double getSide() {
    return this.getHeight();
  }

  @Override
  public String getNameString() {
    return "Override :  " + super.getNameString();
  }

}
