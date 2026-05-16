abstract class ParkingSpot {

  public String getId() {
    return id;
  }

  private String id;
  private VehicleTypes types;
  private boolean occupied;
  private Vehicle vehicle;

  public ParkingSpot(String id,  boolean occupied) {
    this.id = id;
    this.occupied = occupied;
  }

  abstract VehicleTypes getTypes();

  public boolean isOccupied() {
    return occupied;
  }

  public Ticketing assignParkingSpot(Vehicle vehicle) {
    this.occupied  = true;
    this.vehicle = vehicle;
    return new Ticketing(vehicle, this);
  }

  public void unload() {
    this.occupied  = false;
    this.vehicle = null;
  }
}


class CarParkingSpot extends ParkingSpot {

  public CarParkingSpot(String id,  boolean occupied) {
    super(id, occupied);
  }

  @Override
  VehicleTypes getTypes() {
    return VehicleTypes.CAR;
  }
}


class MotorcycleParkingSpot extends ParkingSpot {

  public MotorcycleParkingSpot(String id,  boolean occupied) {
    super(id, occupied);
  }

  @Override
  VehicleTypes getTypes() {
    return VehicleTypes.MOTORCYCLE;
  }
}

class TruckSpot extends ParkingSpot {

  public TruckSpot(String id,  boolean occupied) {
    super(id, occupied);
  }

  @Override
  VehicleTypes getTypes() {
    return VehicleTypes.TRUCK;
  }
}
