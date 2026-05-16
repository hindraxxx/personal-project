
import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
  private int maxFloor;
  private int numberOfElevators;
  private List<ElevatorModel> elevators;

  public ElevatorSystem(int maxFloor, int numberOfElevators){
    this.maxFloor = maxFloor;
    this.numberOfElevators = numberOfElevators;
    this.elevators = new ArrayList<>();

    for(int i = 0; i < numberOfElevators; i++){
      elevators.add(new ElevatorModel());
    }
  }

  public ElevatorModel requestPickup(Integer floor, ElevatorDirection elevatorDirection){
    ElevatorModel elevatorModel = findPriorityElevator(floor, elevatorDirection);
    elevatorModel.pickup(floor,  elevatorDirection);
    return elevatorModel;
  }

  public void selectDestination(ElevatorModel elevatorModel, Integer floor, ElevatorDirection elevatorDirection){
    elevatorModel.serving(elevatorDirection, floor);
  }

  public void step() {
    for (ElevatorModel elevatorModel : elevators) {
      elevatorModel.step(maxFloor);
    }
  }

  private ElevatorModel findPriorityElevator(Integer floor, ElevatorDirection elevatorDirection){
    ElevatorModel chosen = null;
    int bestScore = 0;
    for (ElevatorModel elevator : elevators){
      int score = elevator.elevatorScore(elevatorDirection, floor);
      if (score > bestScore){
        bestScore = score;
        chosen = elevator;
      }
    }
    return chosen;
  }


}
