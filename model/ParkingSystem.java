import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ParkingSystem {
  public HashMap<VehicleTypes, List<ParkingSpot>> parkingSpots = new HashMap<>();
  public HashMap<String, ParkingSpot> mapParkingSpotToID = new HashMap<>();

  public void put(VehicleTypes parkingSpotType, ParkingSpot parkingSpots) {
    List<ParkingSpot> existingSpot = this.parkingSpots.get(parkingSpotType);
    if (existingSpot == null) {
      existingSpot = new ArrayList<>();
    }
    existingSpot.add(parkingSpots);
    this.parkingSpots.put( parkingSpotType, existingSpot);
    this.mapParkingSpotToID.put(parkingSpots.getId(), parkingSpots);
  }

  private ParkingSpot findParkingSlots(VehicleTypes types){
    ParkingSpot spot = parkingSpots.getOrDefault(types, Collections.emptyList()).stream().filter(parkingSpot -> !parkingSpot.isOccupied()).findFirst().orElse(null);
    if (spot == null && types == VehicleTypes.CAR ) {
      return parkingSpots.getOrDefault(VehicleTypes.TRUCK, Collections.emptyList()).stream().filter(parkingSpot -> !parkingSpot.isOccupied()).findFirst().orElse(null);
    }
    return spot;
  }

  private ParkingSpot findParkingSlotsByID(String id){
    return mapParkingSpotToID.get(id);
  }

  public Ticketing assignSpot(Vehicle vehicle){
    ParkingSpot slot = findParkingSlots(vehicle.getType());
    if (slot == null){
      System.out.println("Parking Spot is full");
      return null;
    }
    Ticketing ticket = slot.assignParkingSpot(vehicle);
    System.out.println("Parking Spot is succesfully assigned");
    return ticket;
  }

  public void unload(Ticketing ticketing){
    ParkingSpot slot = findParkingSlotsByID(ticketing.getSpot().getId());
    if (slot == null){
      System.out.println("Parking Spot is not found");
      return;
    }
    slot.unload();
    System.out.println("Parking Spot is succesfully unloaded");
  }
}
