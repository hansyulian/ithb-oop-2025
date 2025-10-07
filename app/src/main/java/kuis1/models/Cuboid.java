package kuis1.models;

public class Cuboid extends Object3D {
  private double length;
  private double width;
  private double height;

  public Cuboid(double length, double width, double height) {
    this(ShapeName.CUBOID, length, width, height);
  }

  public Cuboid(ShapeName shapeName, double length, double width, double height) {
    super(shapeName);
    this.length = length;
    this.width = width;
    this.height = height;
  }

  public double getLength() {
    return length;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public double getVolume() {
    return length * width * height;
  }

  @Override
  public double getSurfaceArea() {
    return 2 * (length * width + length * height + width * height);
  }
}
