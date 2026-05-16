import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.reflect.Field;
import java.util.List;
import java.util.SortedSet;
import org.junit.jupiter.api.Test;

class ElevatorSystemTest {

  @Test
  void constructorCreatesRequestedNumberOfElevators() {
    ElevatorSystem system = new ElevatorSystem(10, 2);

    assertEquals(2, elevators(system).size());
  }

  @Test
  void pickupAssignsElevatorAndQueuesPickupFloor() {
    ElevatorSystem system = new ElevatorSystem(10, 2);

    ElevatorModel assignedElevator = system.requestPickup(6, ElevatorDirection.DOWN);

    assertSame(elevators(system).get(0), assignedElevator);
    assertEquals(ElevatorMode.PICKING_UP, field(assignedElevator, "mode"));
    assertEquals(ElevatorDirection.DOWN, field(assignedElevator, "pickupDirection"));
    assertEquals(sortedSetOf(6), field(assignedElevator, "upStopFloor"));
  }

  @Test
  void stepMovesElevatorOneFloorAtATimeTowardPickup() {
    ElevatorSystem system = new ElevatorSystem(10, 1);
    ElevatorModel elevator = system.requestPickup(3, ElevatorDirection.UP);

    system.step();
    assertEquals(2, field(elevator, "currentFloor"));
    assertEquals(sortedSetOf(3), field(elevator, "upStopFloor"));

    system.step();
    assertEquals(3, field(elevator, "currentFloor"));
    assertEquals(sortedSetOf(), field(elevator, "upStopFloor"));
  }

  @Test
  void destinationRequestQueuesDestinationAfterPickup() {
    ElevatorSystem system = new ElevatorSystem(10, 1);
    ElevatorModel elevator = system.requestPickup(3, ElevatorDirection.UP);

    system.step();
    system.step();
    system.selectDestination(elevator, 7, ElevatorDirection.UP);

    assertEquals(ElevatorMode.SERVING_PASSENGERS, field(elevator, "mode"));
    assertEquals(sortedSetOf(7), field(elevator, "upStopFloor"));
  }

  @SuppressWarnings("unchecked")
  private static List<ElevatorModel> elevators(ElevatorSystem system) {
    return (List<ElevatorModel>) field(system, "elevators");
  }

  @SuppressWarnings("unchecked")
  private static SortedSet<Integer> sortedSetOf(Integer... floors) {
    SortedSet<Integer> floorsSet = new java.util.TreeSet<>();
    for (Integer floor : floors) {
      floorsSet.add(floor);
    }
    return floorsSet;
  }

  private static Object field(Object target, String fieldName) {
    try {
      Field field = target.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      return field.get(target);
    } catch (ReflectiveOperationException e) {
      throw new AssertionError("Unable to read field: " + fieldName, e);
    }
  }
}
