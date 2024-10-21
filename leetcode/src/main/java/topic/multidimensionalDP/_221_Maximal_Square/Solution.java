package topic.multidimensionalDP._221_Maximal_Square;

public class Solution {
    // Main function to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int result = solution.maximalSquare(matrix);
        System.out.println("Maximal Square Area: " + result); // Expected output: 4
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int maxSide = 0;

        // Initialize two 1D arrays to store previous and current row results
        int[] prev = new int[n + 1]; // The previous row
        int[] curr = new int[n + 1]; // The current row being processed

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // Update current row based on the previous row and previous column
                    curr[j] = Math.min(prev[j], Math.min(curr[j - 1], prev[j - 1])) + 1;
                    maxSide = Math.max(maxSide, curr[j]);
                } else {
                    curr[j] = 0; // No square can be formed here
                }
            }
            // Swap rows: move current to previous for the next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        // Return the area of the largest square found
        return maxSide * maxSide;
    }
}
