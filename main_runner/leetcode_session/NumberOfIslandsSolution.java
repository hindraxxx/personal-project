import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslandsSolution {
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;

    int rows = grid.length;
    int cols = grid[0].length;
    int count = 0;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1') {
          count++;
          bfs(grid, r, c);
        }
      }
    }

    return count;
  }

  private void bfs(char[][] grid, int startRow, int startCol) {
    Deque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] {startRow, startCol});
    grid[startRow][startCol] = '0';

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();

      for (int[] dir : DIRS) {
        int nr = cell[0] + dir[0];
        int nc = cell[1] + dir[1];

        if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
          grid[nr][nc] = '0';
          queue.offer(new int[] {nr, nc});
        }
      }
    }
  }
}
