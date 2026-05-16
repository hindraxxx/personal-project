import java.util.List;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    List<Integer> nums = List.of(10, 9, 2, 5, 3, 7, 101, 18);

    int result = lengthOfLis(nums);

    System.out.println(result);
  }

  public static int lengthOfLis(List<Integer> nums) {
    int[] dp = new int[nums.size()];
    int maxValue = 1;
    for (int i = 0; i < nums.size(); i++) {
      if (i == 0){
        dp[i] = 1;
        continue;
      }

      int lookbackValue = lookBackValue(nums, nums.get(i), i, dp);
      dp[i] = lookbackValue + 1;
      maxValue = Math.max(maxValue, dp[i]);
    }
    return maxValue;
  }

  private static int lookBackValue(List<Integer> nums, int value, int index, int[] dp) {
    int lookbackValue = 0;
    for (int i = 0; i<index; i++){
      if(nums.get(i) >= value){
        continue;
      }
      lookbackValue = Math.max(lookbackValue, dp[i]);
    }

    return lookbackValue;
  }
}
