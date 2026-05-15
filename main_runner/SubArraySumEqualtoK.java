import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumEqualtoK {

  public static void main(String[] args) {
    int target = 2;
    List<Integer> list = List.of(1, 1, 1);

    int result = subarraySum(list, target);
    System.out.println(result);
  }

  public static int subarraySum(List<Integer> nums, int k) {
    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);

    int prefix = 0;
    int count = 0;

    for (int num : nums) {
      prefix += num;
      int need = prefix - k;
      count += prefixCount.getOrDefault(need, 0);
      prefixCount.put(prefix, prefixCount.getOrDefault(prefix, 0) + 1);
    }

    return count;
  }
}
