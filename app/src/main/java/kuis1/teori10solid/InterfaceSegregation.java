package teori10solid;

interface VehicleCapability {
  void startEngine();

  void stopEngine();

  void turnLeft();

  void turnRight();

  void moveForward();

  void moveBackward();
}

interface Movable {
  void moveForward();

  void moveBackward();

  void turnLeft();

  void turnRight();
}

interface WithEngine {
  void startEngine();

  void stopEngine();
}

class WrongCart implements VehicleCapability {

  // Because of the interface segregation got violated
  // liskov also got violated
  @Override
  public void startEngine() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void stopEngine() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void turnLeft() {
    System.out.println("Turn Left");
  }

  @Override
  public void turnRight() {
    System.out.println("Turn Right");
  }

  @Override
  public void moveForward() {
    System.out.println("Move Forward");
  }

  @Override
  public void moveBackward() {
    System.out.println("Move Backward");
  }
}

class Cart implements Movable {

  @Override
  public void turnLeft() {
    System.out.println("Turn Left");
  }

  @Override
  public void turnRight() {
    System.out.println("Turn Right");
  }

  @Override
  public void moveForward() {
    System.out.println("Move Forward");
  }

  @Override
  public void moveBackward() {
    System.out.println("Move Backward");
  }
}