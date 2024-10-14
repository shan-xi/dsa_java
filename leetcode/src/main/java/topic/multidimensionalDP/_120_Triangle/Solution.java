package topic.multidimensionalDP._120_Triangle;

import java.util.List;

public class Solution {
    // Main function for testing
    public static void main(String[] args) {
        Solution triangleSolver = new Solution();

        // Example triangle
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );

        int result = triangleSolver.minimumTotal(triangle);
        System.out.println("Minimum path sum: " + result);  // Expected output: 11
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Initialize a 1D dp array to store the minimum path sum for the current row.
        int[] dp = new int[n];

        // Copy the last row of the triangle into dp.
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Iterate from the second last row to the top of the triangle.
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Update dp[col] by taking the minimum of the two adjacent numbers in the next row.
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // The top element of dp now contains the minimum path sum.
        return dp[0];
    }
}
