package teori10dp;

import kuis1.models.Cube;
import kuis1.models.Cuboid;
import kuis1.models.Cylinder;
import kuis1.models.Object3D;
import kuis1.models.ObjectName;
import kuis1.models.Sphere;

public class SimpleObjectFactory {
  public Object3D create(ObjectName type) {
    switch (type) {
      case SPHERE:
        return new Sphere(1.0);
      case CYLINDER:
        return new Cylinder(1.0, 1.0);
      case CUBOID:
        return new Cuboid(1.0, 1.0, 1.0);
      case CUBE:
        return new Cube(1.0);
      default:
        return null;
    }
  }
}
