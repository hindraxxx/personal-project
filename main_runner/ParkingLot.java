import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {

  public static void main(String[] args) {
    ParkingSystem parkingSystem = buildInitialParkingSlots();

    Vehicle car = new Car();
    Vehicle motor = new Motor();
    Vehicle truck = new Truck();

    // Happy path examples.
    parkingSystem.assignSpot(car);
    parkingSystem.assignSpot(motor);
    parkingSystem.assignSpot(truck);

    // TODO:
    // 1. Change assignSpot so caller does not pass VehicleTypes manually.
    //    ParkingSystem can read vehicle.getType().
    // 2. Add Ticket return value from assignSpot.
    // 3. Add unpark(ticketId) or unpark(vehicleId).
    // 4. Add smallest-compatible-slot logic:
    //    - Motor -> motorcycle slot.
    //    - Car -> car/compact first, then truck/large.
    //    - Truck -> truck/large only.
    // 5. Track duplicate vehicles.
  }

  private static ParkingSystem buildInitialParkingSlots() {
    ParkingSystem parkingSystem = new ParkingSystem();


    addMotorcycleSlots(parkingSystem, 2);
    addCarSlots(parkingSystem, 2);
    addTruckSlots(parkingSystem, 1);

    return parkingSystem;
  }

  private static void addMotorcycleSlots(
      ParkingSystem parkingSystem,
      int count
  ) {
    for (int i = 0; i < count; i++) {
      String id = String.format("Motorcycle-%d", i);
      parkingSystem.put(VehicleTypes.MOTORCYCLE, new MotorcycleParkingSpot(id,false));
    }
  }

  private static void addCarSlots(
      ParkingSystem parkingSystem,
      int count
  ) {
    for (int i = 0; i < count; i++) {
      String id = String.format("Car-%d", i);

      parkingSystem.put(VehicleTypes.CAR, new CarParkingSpot(id,false));
    }
  }

  private static void addTruckSlots(
      ParkingSystem parkingSystem,
      int count
  ) {
    for (int i = 0; i < count; i++) {
      String id = String.format("Truck-%d", i);
      parkingSystem.put(VehicleTypes.TRUCK, new TruckSpot(id,false));
    }
  }
}
