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
import kuis1.repositories.ObjectRepository;

public class ObjectController {

  private ObjectRepository objectRepository;

  public ObjectController() {
    this.objectRepository = new ObjectRepository();
  }

  public List<Object3D> getAllObjects() {
    return this.objectRepository.findAll();
  }

  public void add(Object3D object) {
    this.objectRepository.add(object);
  }

  public void addSphere(int radius) {
    this.add(new Sphere(radius));
  }

  public void addCylinder(int radius, int height) {
    this.add(new Cylinder(radius, height));
  }

  public void addCuboid(int length, int width, int height) {
    this.add(new Cuboid(length, width, height));
  }

  public void addCube(int side) {
    this.add(new Cube(side));
  }
}
