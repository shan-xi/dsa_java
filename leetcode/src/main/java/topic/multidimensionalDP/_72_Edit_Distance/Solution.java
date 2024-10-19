package topic.multidimensionalDP._72_Edit_Distance;

public class Solution {

    // Main function to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        String word1 = "horse";
        String word2 = "ros";

        int result = solution.minDistance(word1, word2);
        System.out.println("Minimum Edit Distance: " + result); // Expected output: 3
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Initialize a DP table with dimensions (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Fill the base cases for when one of the strings is empty
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // It takes i deletions to make word1 of length i into an empty string
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // It takes j insertions to make an empty string into word2 of length j
        }

        // Fill the DP table using the recurrence relation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation required
                } else {
                    // Insert, Delete, or Replace
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],
                            Math.min(
                                    dp[i][j - 1],
                                    dp[i - 1][j]
                            )
                    );
                }
            }
        }

        // The final answer is the edit distance between the full strings
        return dp[m][n];
    }
}
