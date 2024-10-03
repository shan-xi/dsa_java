package topic.dp._198_House_Robber;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Multiple houses
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Max money robbed: " + solution.rob(nums1));  // Output: 4

        // Test case 2: Another scenario
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Max money robbed: " + solution.rob(nums2));  // Output: 12

        // Test case 3: Single house
        int[] nums3 = {10};
        System.out.println("Max money robbed: " + solution.rob(nums3));  // Output: 10

        // Test case 4: Empty houses
        int[] nums4 = {};
        System.out.println("Max money robbed: " + solution.rob(nums4));  // Output: 0

        // Test case 5: All houses with same money
        int[] nums5 = {10, 10, 10, 10};
        System.out.println("Max money robbed: " + solution.rob(nums5));  // Output: 20
    }

    public int rob(int[] nums) {
        // Base case: no houses to rob
        if (nums.length == 0) return 0;

        // Base case: only one house to rob
        if (nums.length == 1) return nums[0];

        // Variables to track the maximum amount robbed up to the previous house and the one before it
        int prev2 = 0;  // dp[i-2]
        int prev1 = 0;  // dp[i-1]

        // Iterate through each house
        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        // The last value of prev1 will be the maximum amount robbed
        return prev1;
    }
}
