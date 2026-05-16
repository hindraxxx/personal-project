import java.util.Arrays;
import java.util.List;

public class CoinChange {

  public static void main(String[] args) {
    List<Integer> coins = List.of(1, 2, 5);
    int amount = 11;

    int result = minCoins(coins, amount);

    System.out.println(result);
  }

  public static int minCoins(List<Integer> coins, int amount) {
    if (coins.size() == 1 && coins.get(0) != amount) return -1;
    if (coins.size() == 1 && coins.get(0) == amount) return 1;

    int[] dp = new int[amount+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 1;
    for (int i = 1; i <= amount; i++) {
      for(int coin: coins) {
        if (i - coin >= 0) {
          dp[i] = Math.min(dp[i],dp[i-coin] +1);
        }
      }
    }
    return dp[amount];
  }
}
