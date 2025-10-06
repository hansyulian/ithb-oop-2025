package kuis1.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kuis1.models.Object3D;
import kuis1.models.Cube;
import kuis1.models.Cuboid;
import kuis1.models.Cylinder;
import kuis1.models.Sphere;

public class ObjectController {

  class Object3DComparator implements Comparator<Object3D> {
    boolean isAscending;

    public Object3DComparator() {
      this(true);
    }

    public Object3DComparator(boolean isAscending) {
      this.isAscending = isAscending;
    }

    @Override
    public int compare(Object3D o1, Object3D o2) {
      if (isAscending) {
        return o1.getVolume() - o2.getVolume();
      }
      return o2.getVolume() - o1.getVolume();
    }
  }

  private List<Object3D> objects;

  public ObjectController() {
    this.objects = new ArrayList<>();
  }

  public List<Object3D> getAllObjects() {
    return this.objects;
  }

  public void add(Object3D object) {
    this.objects.add(object);
  }

  public void sortObjects() {
    this.sortObjects(false);
  }

  public void sortObjects(boolean isAscending) {
    Collections.sort(this.objects, new Object3DComparator(isAscending));
  }

  public Object3D generateObject(int radius) {
    return new Sphere(radius);
  }

  public Object3D generateObject(int radius, int height) {
    return new Cylinder(radius, height);
  }

  public Object3D generateObject(int length, int width, int height) {
    return new Cuboid(length, width, height);
  }

  public Object3D generateObject(int side, boolean isCube) {
    if (isCube)
      return new Cube(side);
    else
      return new Sphere(side);
  }
}
