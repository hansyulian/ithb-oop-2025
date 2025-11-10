package teori10dp;

import kuis1.models.Cube;
import kuis1.models.Cuboid;
import kuis1.models.Cylinder;
import kuis1.models.Object3D;
import kuis1.models.Sphere;

public class ObjectFactory {
  public Object3D create(double radius) {
    return new Sphere(radius);
  }

  public Object3D create(double radius, double height) {
    return new Cylinder(radius, height);
  }

  public Object3D create(double length, double width, double height) {
    return new Cuboid(length, width, height);
  }

  public Object3D create(double side, boolean isCube) {
    if (isCube) {
      return new Cube(side);
    }
    return new Sphere(side);
  }
}
