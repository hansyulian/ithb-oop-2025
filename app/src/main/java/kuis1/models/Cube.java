package kuis1.models;

public class Cube extends Cuboid {

  public Cube(int side) {
    super(ShapeName.CUBE, side, side, side);
  }

  public int getSide() {
    return this.getHeight();
  }

  @Override
  public String getNameString() {
    return "Override :  " + super.getNameString();
  }

}