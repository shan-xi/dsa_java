package topic.multidimensionalDP._63_Unique_Paths_II;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] obstacleGrid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid1)); // Output: 2

        int[][] obstacleGrid2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid2)); // Output: 1

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting point is an obstacle, there are no paths.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Initialize a dp array for the number of ways to reach each cell
        int[] dp = new int[n];
        dp[0] = 1; // There's only one way to start at the top-left corner if it's not an obstacle

        // Fill the dp array row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // No path through obstacles
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // Add paths from the left and top
                }
            }
        }

        // The answer is in dp[n-1], the number of ways to reach the bottom-right corner
        return dp[n - 1];
    }
}
