# Elevator System

## Prompt

Design a simplified elevator system for a building.

## Core Requirements

- Support multiple elevators and floors.
- Accept pickup requests from floors.
- Accept destination requests from inside elevators.
- Move elevators one step at a time.
- Track elevator direction, current floor, and assigned stops.
- Open doors when reaching a requested floor.

## Suggested API

```java
ElevatorSystem system = new ElevatorSystem(10, 2);
system.requestPickup(3, Direction.UP);
system.step();
List<ElevatorSnapshot> elevators = system.snapshot();
```

## Follow-Ups

- Choose nearest elevator.
- Handle up/down queues separately.
- Add capacity limits.
- Add emergency stop.
- Add maintenance mode.
- Optimize average wait time.

## Validation Cases

- Idle elevator accepts pickup.
- Elevator moves toward assigned floor.
- Elevator opens at requested floor.
- Multiple stops are served in direction order.
- Requests outside building fail.
- Elevator at capacity rejects pickup.

## Design Signals

- Scope this tightly in 30 minutes.
- Separate scheduler from elevator state.
- Prefer deterministic tests over real time.
- Explain tradeoff between simple nearest-elevator and direction-aware scheduling.

