package topic.dp._322_Coin_Change;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + result);

        // Test case where no solution is possible
        int amount2 = 3;
        int[] coins2 = {2};
        int result2 = solution.coinChange(coins2, amount2);
        System.out.println("Minimum coins needed: " + result2);
    }

    public int coinChange(int[] coins, int amount) {
        // Initialize the DP array with a value larger than any possible solution (amount + 1)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // Base case: 0 coins are needed to make amount 0

        // Iterate over all the amounts from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // Only update dp[i] if the coin value is less than or equal to i
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still amount + 1, it means it's not possible to make the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}