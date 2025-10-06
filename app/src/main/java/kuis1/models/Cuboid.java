package kuis1.models;

public class Cuboid extends Object3D {
  private int length;
  private int width;
  private int height;

  public Cuboid(int length, int width, int height) {
    this(ShapeName.CUBOID, length, width, height);
  }

  public Cuboid(ShapeName shapeName, int length, int width, int height) {
    super(shapeName);
    this.length = length;
    this.width = width;
    this.height = height;
  }

  public int getLength() {
    return length;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public int getVolume() {
    return length * width * height;
  }

  @Override
  public int getSurfaceArea() {
    return 2 * (length * width + length * height + width * height);
  }
}
