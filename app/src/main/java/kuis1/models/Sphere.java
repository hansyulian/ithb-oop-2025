
package kuis1.models;

public class Sphere extends Object3D {
  private int radius;

  public Sphere(int radius) {
    super(ShapeName.SPHERE);
    this.radius = radius;
  }

  public int getRadius() {
    return radius;
  }

  @Override
  public int getVolume() {
    return (int) (4.0 / 3.0 * Math.PI * radius * radius * radius);
  }

  @Override
  public int getSurfaceArea() {
    return (int) (4.0 * Math.PI * radius * radius);
  }
}