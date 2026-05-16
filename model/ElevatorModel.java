import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class ElevatorModel {
  private ElevatorDirection elevatorDirection = ElevatorDirection.UP;
  private ElevatorDirection pickupDirection = ElevatorDirection.UP;
  private ElevatorMode mode = ElevatorMode.IDLE;
  private Integer currentFloor = 1;
  private SortedSet<Integer> upStopFloor = new TreeSet<>();;
  private SortedSet<Integer> downStopFloor = new TreeSet<>(Comparator.reverseOrder());;

  public ElevatorDirection getElevatorDirection() {
    return elevatorDirection;
  }

  public ElevatorDirection getPickupDirection() {
    return pickupDirection;
  }

  public ElevatorMode getMode() {
    return mode;
  }

  public Integer getCurrentFloor() {
    return currentFloor;
  }

  public SortedSet<Integer> getUpStopFloor() {
    return upStopFloor;
  }

  public SortedSet<Integer> getDownStopFloor() {
    return downStopFloor;
  }


  private boolean isIdle(){
    return mode == ElevatorMode.IDLE;
  }

  private boolean isGoingUp(){
    return Objects.equals(elevatorDirection, ElevatorDirection.UP);
  }

  private boolean isGoingDown(){
    return Objects.equals(elevatorDirection, ElevatorDirection.DOWN);
  }


  private void queueUp(Integer floor){
    upStopFloor.add(floor);
  }

  private void queueDown(Integer floor){
    downStopFloor.add(floor);
  }

  public int elevatorScore(ElevatorDirection userElevatorDirection, Integer floor){
    if(this.elevatorDirection.equals(userElevatorDirection)){
      return 1000+ Math.abs(this.currentFloor - floor);
    } else if (this.isIdle()){
      return 50 + Math.abs(this.currentFloor - floor);
    } else {
      if (isGoingUp()){
        return Math.toIntExact(50 - downStopFloor.stream().count());
      }else {
        return Math.toIntExact(50 - upStopFloor.stream().count());
      }
    }
  }

  public void pickup(Integer floor, ElevatorDirection pickupDirection){
    this.mode = ElevatorMode.PICKING_UP;
    this.pickupDirection = pickupDirection;
    if (Objects.equals(floor, currentFloor)){
      return;
    }
    if(floor > currentFloor){
      queueUp(floor);
    }else{
      queueDown(floor);
    }
  }

  public void serving(ElevatorDirection elevatorDirection, Integer floor){
    this.mode = ElevatorMode.SERVING_PASSENGERS;
    if (Objects.equals(floor, currentFloor)){
      return;
    }
    if(floor > currentFloor){
      this.elevatorDirection = ElevatorDirection.UP;
      queueUp(floor);
    }else{
      this.elevatorDirection = ElevatorDirection.DOWN;
      queueDown(floor);
    }
  }

  public void step(int maxFloor){
    if (this.mode == ElevatorMode.IDLE || (this.upStopFloor.isEmpty() && this.downStopFloor.isEmpty())){
      return;
    }

    if (elevatorDirection == ElevatorDirection.UP ){
      if (this.currentFloor != maxFloor){
        this.currentFloor += 1;
        if(this.upStopFloor.contains(this.currentFloor)){
          this.upStopFloor.remove(this.currentFloor);
        }
      }else {
        if(downStopFloor.size() > 0){
          elevatorDirection = ElevatorDirection.DOWN;
        }
      }
    }

    if(elevatorDirection == ElevatorDirection.DOWN){
      if(this.currentFloor != 1){
        this.currentFloor -= 1;
        if(this.downStopFloor.contains(this.currentFloor)){
          this.downStopFloor.remove(this.currentFloor);
        }
      }else{
        if(upStopFloor.size() > 0)
        {
          elevatorDirection = ElevatorDirection.UP;
        }
      }
    }
  }
}
