import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumSubarray {

  public static void main(String[] args) {
    List<Integer> list = List.of(-2,1,-3,4,-1,2,1,-5,4);

    Integer pairs = maximumSubArray(list);

      System.out.println(pairs + " ");
  }

  public static Integer maximumSubArray(List<Integer> nums) {
    int currentBest = nums.get(0);
    int globalBest = nums.get(0);

    for (int i = 1; i < nums.size(); i++) {
      int num = nums.get(i);

      currentBest = Math.max(num, currentBest + num);
      globalBest = Math.max(globalBest, currentBest);
    }

    return globalBest;
  }
}
