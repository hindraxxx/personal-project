public class GridUniquePathsWithBlocks {

  public static void main(String[] args) {
    int[][] grid = {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    };

    int result = countPaths(grid);

    System.out.println(result);
  }

  public static int countPaths(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int[][] dp = new int[row+1][col+1];
    dp[0][0] = 1;

    for (int i = 0; i <= row-1; i++) {
      for (int j = 0; j <= col-1; j++) {

        if (grid[i][j] == 1){
          dp[i][j] = 0;
        }else{
          if(i>0){
            dp[i][j] += dp[i-1][j];
          }

          if(j>0){
            dp[i][j] += dp[i][j-1];
          }
        }
      }
    }
    return dp[row-1][col-1];
  }
}
