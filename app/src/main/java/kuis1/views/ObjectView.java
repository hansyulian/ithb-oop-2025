
package kuis1.views;

import java.util.Comparator;
import java.util.List;

import kuis1.controllers.ObjectController;
import kuis1.models.Object3D;
import kuis1.util.CLIUtil;

public class ObjectView {
  private ObjectController objectController;

  public ObjectView() {
    this.objectController = new ObjectController();
  }

  public void render() {
    System.out.println("Menu:");
    System.out.println("1. Add new 3D object");
    System.out.println("2. Print all");
    System.out.println("3. Print all Sorted by volume ascending");
    System.out.println("4. Print all Sorted by volume descending");
    System.out.println("0. Exit");
    System.out.print("Your choice: ");
    handleUserInput();
  }

  private void handleUserInput() {
    int input = CLIUtil.getInt();
    switch (input) {
      case 1:
        renderAddView();
        break;
      case 2:
        renderListView();
        break;
      case 3:
        renderListView(true);
        break;
      case 4:
        renderListView(false);
        break;
    }
    if (input != 0) {
      render();
    }
  }

  public void renderAddView() {
    System.out.println("    1. Sphere");
    System.out.println("    2. Cylinder");
    System.out.println("    3. Cuboid");
    System.out.println("    4. Cube");
    System.out.print("    Your choice: ");
    int shape = CLIUtil.getInt();
    switch (shape) {
      case 1: {
        handleAddNewSphereObject();
        break;
      }
      case 2: {
        handleAddNewCylinderObject();
        break;
      }
      case 3: {
        handleAddNewCuboidObject();
        break;
      }
      case 4: {
        handleAddNewCubeObject();
        break;
      }
    }
  }

  private void handleAddNewSphereObject() {
    System.out.print("        Input the radius of the sphere: ");
    int radius = CLIUtil.getInt();
    objectController.addSphere(radius);
  }

  private void handleAddNewCylinderObject() {
    System.out.print("        Input the radius of the cylinder: ");
    int radius = CLIUtil.getInt();
    System.out.print("        Input the height of the cylinder: ");
    int height = CLIUtil.getInt();
    objectController.addCylinder(radius, height);
  }

  private void handleAddNewCuboidObject() {
    System.out.print("        Input the length of the cuboid: ");
    int length = CLIUtil.getInt();
    System.out.print("        Input the width of the cuboid: ");
    int width = CLIUtil.getInt();
    System.out.print("        Input the height of the cuboid: ");
    int height = CLIUtil.getInt();
    objectController.addCuboid(length, width, height);
  }

  private void handleAddNewCubeObject() {
    System.out.print("        Input the side length of the cube: ");
    int side = CLIUtil.getInt();
    objectController.addCube(side);
  }

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
      boolean isO1LargerThanO2 = o1.getVolume() > o2.getVolume();
      if (isAscending != isO1LargerThanO2) {
        return -1;
      }
      return 1;
    }
  }

  public void renderListView() {
    var objects = objectController.getAllObjects();
    renderListView(objects);
  }

  public void renderListView(boolean sortedByVolumeAscending) {
    var objects = objectController.getAllObjects();
    objects.sort(new Object3DComparator(sortedByVolumeAscending));
    renderListView(objects);
  }

  private void renderListView(List<Object3D> objects) {
    for (int i = 0; i < objects.size(); i++) {
      Object3D object = objects.get(i);
      double volume = object.getVolume();
      double surfaceArea = object.getSurfaceArea();
      String objectName = object.getNameString();
      System.out.println("    Name: " + objectName + ", Volume: " + volume
          + ", Surface Area: " + surfaceArea);
    }
  }
}
