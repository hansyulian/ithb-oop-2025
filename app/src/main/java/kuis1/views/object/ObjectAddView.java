package kuis1.views.object;

import kuis1.controllers.ObjectController;
import kuis1.util.CLIUtil;

public class ObjectAddView {
  private ObjectController objectController;

  public ObjectAddView(ObjectController objectController) {
    this.objectController = objectController;
  }

  public void render() {
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

}
