package kuis1.models;

public abstract class Object3D {
  private ObjectName name;

  public Object3D(ObjectName name) {
    this.name = name;
  }

  public ObjectName getName() {
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

  public abstract double getVolume();

  public abstract double getSurfaceArea();
}
