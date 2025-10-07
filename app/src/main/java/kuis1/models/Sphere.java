
package kuis1.models;

public class Sphere extends Object3D {
  private double radius;

  public Sphere(double radius) {
    super(ShapeName.SPHERE);
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public double getVolume() {
    return (4.0 / 3.0 * Math.PI * radius * radius * radius);
  }

  @Override
  public double getSurfaceArea() {
    return (4.0 * Math.PI * radius * radius);
  }
}