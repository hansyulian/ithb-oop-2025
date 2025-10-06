package kuis1.models;

enum ShapeName {
  SPHERE,
  CYLINDER,
  CUBOID,
  CUBE,
  UNKNOWN,
}

public abstract class Object3D {
  private ShapeName name;

  public Object3D(ShapeName name) {
    this.name = name;
  }

  public ShapeName getName() {
    return this.name;
  }

  public String getNameString() {
    switch (name) {
      case SPHERE:
        return "Sphere";
      case CYLINDER:
        return "Cylinder";
      case CUBOID:
        return "Cuboid";
      case CUBE:
        return "Cube";
      default:
        return "Unknown";
    }
  }

  public abstract int getVolume();

  public abstract int getSurfaceArea();
}
