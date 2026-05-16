public class Elevator {

  public static void main(String[] args) {
    ElevatorSystem system = new ElevatorSystem(10, 2);

    ElevatorModel elevator = system.requestPickup(6, ElevatorDirection.DOWN);

    for (int i = 0; i < 5; i++) {
      system.step();
    }

    system.selectDestination(elevator, 1, ElevatorDirection.DOWN);

    for (int i = 0; i < 5; i++) {
      system.step();
    }
  }
}
