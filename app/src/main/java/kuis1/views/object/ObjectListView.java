package kuis1.views.object;

import java.util.Comparator;
import java.util.List;

import kuis1.controllers.ObjectController;
import kuis1.models.Object3D;

public class ObjectListView {
  private ObjectController objectController;

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

  public ObjectListView(ObjectController objectController) {
    this.objectController = objectController;
  }

  public void render() {
    var objects = objectController.getAllObjects();
    render(objects);
  }

  public void render(boolean sortedByVolumeAscending) {
    var objects = objectController.getAllObjects();
    objects.sort(new Object3DComparator(sortedByVolumeAscending));
    render(objects);
  }

  private void render(List<Object3D> objects) {
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
