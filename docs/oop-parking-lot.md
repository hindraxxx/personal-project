# Parking Lot

## Prompt

Design and implement a parking lot system that can park and unpark vehicles.

## Core Requirements

- Support vehicle types: motorcycle, car, truck.
- Support spot types: motorcycle, compact, large.
- Park a vehicle in a compatible spot.
- Unpark by ticket or vehicle ID.
- Track available spots.
- Reject parking when no compatible spot exists.

## Initial Layout

Use this starter layout for implementation and validation:

| Spot type | Initial count | Compatible vehicles |
| --- | ---: | --- |
| Motorcycle | 2 | Motorcycle |
| Compact | 2 | Car |
| Large | 1 | Car, truck |

Allocation should use the smallest compatible spot first:

- Motorcycle -> motorcycle spot.
- Car -> compact spot first, then large spot if compact is full.
- Truck -> large spot only.

## Suggested API

```java
ParkingLot lot = new ParkingLot(layout);
Ticket ticket = lot.park(new Vehicle("ABC123", VehicleType.CAR));
Vehicle vehicle = lot.unpark(ticket.id());
```

## Follow-Ups

- Multiple floors.
- Pricing by duration.
- Reservations.
- Disabled-access spots.
- Electric charging spots.
- Concurrent park/unpark requests.

## Validation Cases

- Motorcycle parks in motorcycle spot.
- Car parks in compact or large spot.
- Truck parks only in large spot.
- Full lot rejects new vehicle.
- Unparking frees the spot.
- Invalid ticket fails.
- Duplicate vehicle parking fails.

## Design Signals

- Model compatibility rules clearly.
- Keep allocation strategy replaceable.
- Avoid giant conditional logic scattered across classes.
- Separate domain model from payment/pricing.
