import java.util.UUID;

public class Ticketing {
  private UUID id;
  private Vehicle vehicle;

  public ParkingSpot getSpot() {
    return spot;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  private ParkingSpot spot;

  public Ticketing(Vehicle vehicle, ParkingSpot spot) {
    this.id = UUID.randomUUID();
    this.vehicle = vehicle;
    this.spot = spot;
  }
}
