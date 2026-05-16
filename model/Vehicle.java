
abstract class Vehicle {
  private String id;
  private String color;
  abstract VehicleTypes getType();
}

class Car extends Vehicle {
  VehicleTypes getType() { return VehicleTypes.CAR; }
}

class Motor extends Vehicle {
  VehicleTypes getType() { return VehicleTypes.MOTORCYCLE; }
}

class Truck extends Vehicle {
  VehicleTypes getType() { return VehicleTypes.TRUCK; }
}
