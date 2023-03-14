package number_of_closed_islands;

// 1254. Number of Closed Islands
// https://leetcode.com/problems/number-of-closed-islands/?envType=study-plan&id=graph-i
public class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    if (isLand(grid, i, j, rows, cols)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isLand(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }

        if (grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;
        boolean up = isLand(grid, i - 1, j, rows, cols);
        boolean down = isLand(grid, i + 1, j, rows, cols);
        boolean left = isLand(grid, i, j - 1, rows, cols);
        boolean right = isLand(grid, i, j + 1, rows, cols);

        return up && down && left && right;
    }
}
