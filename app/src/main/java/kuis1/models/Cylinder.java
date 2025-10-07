package kuis1.models;

public class Cylinder extends Object3D {
  private double radius;
  private double height;

  public Cylinder(double radius, double height) {
    super(ShapeName.CYLINDER);
    this.radius = radius;
    this.height = height;
  }

  public double getRadius() {
    return radius;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public double getVolume() {
    return Math.PI * radius * radius * height;
  }

  @Override
  public double getSurfaceArea() {
    return 2.0 * Math.PI * radius * (radius + height);
  }
}