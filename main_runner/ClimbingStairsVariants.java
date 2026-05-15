import static java.lang.Long.min;

import java.util.List;
import java.util.Set;

public class ClimbingStairsVariants {

  public static void main(String[] args) {
    int simpleSteps = 5;
    List<Integer> allowedSteps = List.of(1, 3, 5);
    List<Integer> stepCosts = List.of(10, 15, 20);
    Set<Integer> blockedSteps = Set.of(2);

    System.out.println(countWays(simpleSteps));
    System.out.println(countWaysWithAllowedSteps(simpleSteps, allowedSteps));
    System.out.println(minCostToTop(stepCosts));
    System.out.println(countWaysWithBlockedSteps(simpleSteps, blockedSteps));
  }

  public static int countWays(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;

    if (n >= 1) {
      dp[1] = 1;
    }

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  public static int countWaysWithAllowedSteps(int n, List<Integer> allowedSteps) {
    int[] dp = new int[n + 1];
    dp[0] = 1;

    for (int x = 1; x <= n; x++) {
      for (int step : allowedSteps) {
        if (x - step >= 0) {
          dp[x] += dp[x - step];
        }
      }
    }

    return dp[n];
  }

  public static int minCostToTop(List<Integer> costs) {
    int n = costs.size();

    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return costs.get(0);
    }

    int[] dp = new int[n];
    dp[0] = costs.get(0);
    dp[1] = costs.get(1);

    for (int i = 2; i < n; i++) {
      dp[i] = costs.get(i) + Math.min(dp[i - 1], dp[i - 2]);
    }

    return Math.min(dp[n - 1], dp[n - 2]);
  }

  public static int countWaysWithBlockedSteps(int n, Set<Integer> blockedSteps) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    if (n >= 1) {
      dp[1] = 1;
    }

    for (int i = 2; i <= n; i++) {
      if(blockedSteps.contains(i)){
        dp[i] = 0;
      }else{
        dp[i] = dp[i - 1] + dp[i - 2];

      }
    }
    return dp[n];
  }
}
