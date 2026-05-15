import java.util.List;

public class CoinChange {

  public static void main(String[] args) {
    List<Integer> coins = List.of(1, 2, 5);
    int amount = 11;

    int result = minCoins(coins, amount);

    System.out.println(result);
  }

  public static int minCoins(List<Integer> coins, int amount) {
    return -1;
  }
}
