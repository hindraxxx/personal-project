import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumOfAllPair {

  public static void main(String[] args) {
    int target = 9;
    List<Integer> list = List.of(2, 7, 11, 15, -2, 9);

    List<List<Integer>> pairs = twoSumUniqueValues(list, target);

    for (List<Integer> pair : pairs) {
      System.out.println(pair.get(0) + " + " + pair.get(1) + " = " + target);
    }
  }

  public static List<List<Integer>> twoSumUniqueValues(List<Integer> nums, int target) {
    Set<Integer> values = new HashSet<>(nums);
    Set<Integer> used = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();

    for (int num : values) {
      int need = target - num;

      if (need == num || !values.contains(need)) {
        continue;
      }

      int small = Math.min(num, need);
      int large = Math.max(num, need);

      if (used.contains(small)) {
        continue;
      }

      result.add(List.of(small, large));
      used.add(small);
    }

    return result;
  }
}
