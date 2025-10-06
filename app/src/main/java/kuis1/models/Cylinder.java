package kuis1.models;

public class Cylinder extends Object3D {
  private int radius;
  private int height;

  public Cylinder(int radius, int height) {
    super(ShapeName.CYLINDER);
    this.radius = radius;
    this.height = height;
  }

  public int getRadius() {
    return radius;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public int getVolume() {
    return (int) (Math.PI * radius * radius * height);
  }

  @Override
  public int getSurfaceArea() {
    return (int) (2.0 * Math.PI * radius * (radius + height));
  }
}