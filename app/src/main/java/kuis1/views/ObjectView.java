
package kuis1.views;

import kuis1.controllers.ObjectController;
import kuis1.models.Object3D;
import kuis1.util.CLIUtil;
import kuis1.views.object.ObjectAddView;
import kuis1.views.object.ObjectListView;

public class ObjectView {
  private ObjectController objectController;
  private ObjectAddView objectAddView;
  private ObjectListView objectListView;

  public ObjectView() {
    this.objectController = new ObjectController();
    this.objectAddView = new ObjectAddView(objectController);
    this.objectListView = new ObjectListView(objectController);
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
        objectAddView.render();
        break;
      case 2:
        objectListView.render();
        break;
      case 3:
        objectListView.render(true);
        break;
      case 4:
        objectListView.render(false);
        break;
    }
    if (input != 0) {
      render();
    }
  }
}
