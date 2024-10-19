package topic.multidimensionalDP._97_Interleaving_String;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3)); // Output: true

        String s1_2 = "aabcc";
        String s2_2 = "dbbca";
        String s3_2 = "aadbbbaccc";
//        System.out.println(solution.isInterleave(s1_2, s2_2, s3_2)); // Output: false
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();

        // If lengths don't add up, return false
        if (m + n != l) {
            return false;
        }

        // Initialize a 1D dp array of size (n + 1)
        boolean[] dp = new boolean[n + 1];

        // Base case: an empty s1 and s2 forms an empty s3
        dp[0] = true;

        // Fill the dp array for the first row (comparing with s2)
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Iterate over s1
        for (int i = 1; i <= m; i++) {
            // First, update dp[0] (comparing with s1)
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);

            // Iterate over s2 and update the dp array
            for (int j = 1; j <= n; j++) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        // The result is stored in dp[n]
        return dp[n];
    }
}
