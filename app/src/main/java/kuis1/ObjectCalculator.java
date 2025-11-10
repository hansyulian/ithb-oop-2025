package kuis1;

import kuis1.models.Cube;
import kuis1.models.Object3D;

public class ObjectCalculator {
  public static double calculateArea(Object3D object3D) {
    if (object3D instanceof Cube) {
      Cube cube = (Cube) object3D;
      return 6 * cube.getSide() * cube.getSide();
    }
    return 0;
  }

  public static double calculateVolume(Object3D object3D) {
    if (object3D instanceof Cube) {
      Cube cube = (Cube) object3D;
      return cube.getSide() * cube.getSide() * cube.getSide();
    }
    return 0;

  }
}
