
package kuis1.views;

import kuis1.controllers.ObjectController;
import kuis1.models.Object3D;
import kuis1.util.CLIUtil;

public class ObjectView {
  private ObjectController objectController;

  public ObjectView() {
    this.objectController = new ObjectController();
  }

  public void start() {
    int input = handleMenuAction();
    while (input != 0) {
      switch (input) {
        case 1:
          handleAddNewObject();
          break;
        case 2:
          handlePrintAllObjects();
          break;
        case 3:
          handleSortByVolume();
          break;
      }
      input = handleMenuAction();
    }

  }

  private int handleMenuAction() {
    System.out.println("Menu:");
    System.out.println("1. Add new 3D object");
    System.out.println("2. Print all");
    System.out.println("3. Sort by volume");
    System.out.println("0. Exit");
    System.out.print("Your choice: ");
    return CLIUtil.getInt();
  }

  private void handleAddNewObject() {
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
    objectController.add(objectController.generateObject(radius));
  }

  private void handleAddNewCylinderObject() {
    System.out.print("        Input the radius of the cylinder: ");
    int radius = CLIUtil.getInt();
    System.out.print("        Input the height of the cylinder: ");
    int height = CLIUtil.getInt();
    objectController.add(objectController.generateObject(radius, height));
  }

  private void handleAddNewCuboidObject() {
    System.out.print("        Input the length of the cuboid: ");
    int length = CLIUtil.getInt();
    System.out.print("        Input the width of the cuboid: ");
    int width = CLIUtil.getInt();
    System.out.print("        Input the height of the cuboid: ");
    int height = CLIUtil.getInt();
    objectController.add(objectController.generateObject(length, width, height));
  }

  private void handleAddNewCubeObject() {
    System.out.print("        Input the side length of the cube: ");
    int side = CLIUtil.getInt();
    objectController.add(objectController.generateObject(side, true));
  }

  private void handlePrintAllObjects() {
    var objects = objectController.getAllObjects();
    for (int i = 0; i < objects.size(); i++) {
      Object3D object = objects.get(i);
      int volume = object.getVolume();
      int surfaceArea = object.getSurfaceArea();
      String objectName = object.getNameString();
      System.out.println("    Name: " + objectName + ", Volume: " + volume
          + ", Surface Area: " + surfaceArea);
    }
  }

  private void handleSortByVolume() {
    objectController.sortObjects();
  }
}
