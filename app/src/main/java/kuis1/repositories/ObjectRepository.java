package kuis1.repositories;

import java.util.ArrayList;
import java.util.List;

import kuis1.models.Object3D;

public class ObjectRepository {
  private List<Object3D> objects;

  public ObjectRepository() {
    this.objects = new ArrayList<>();
  }

  public List<Object3D> findAll() {
    return this.objects;
  }

  public void add(Object3D object) {
    this.objects.add(object);
  }

}
