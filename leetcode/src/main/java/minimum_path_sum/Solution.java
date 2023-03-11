package minimum_path_sum;

//64. Minimum Path Sum
//https://leetcode.com/problems/minimum-path-sum/
class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // row initialize
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // col initialize
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // find minimum
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
