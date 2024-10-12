package topic.dp._300_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int result1 = solution.lengthOfLIS(nums1);
        System.out.println("Length of Longest Increasing Subsequence: " + result1);  // Output: 4 (LIS is [2, 3, 7, 18])

        // Test case 2
//        int[] nums2 = {0, 1, 0, 3, 2, 3};
//        int result2 = solution.lengthOfLIS(nums2);
//        System.out.println("Length of Longest Increasing Subsequence: " + result2);  // Output: 4 (LIS is [0, 1, 2, 3])
//
//        // Test case 3
//        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
//        int result3 = solution.lengthOfLIS(nums3);
//        System.out.println("Length of Longest Increasing Subsequence: " + result3);  // Output: 1 (LIS is [7])
    }

    public int lengthOfLIS(int[] nums) {
        // Edge case: empty input
        if (nums == null || nums.length == 0) return 0;

        // dp array that stores the smallest possible ending value of subsequences of different lengths
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            // Binary search to find the index to replace or extend
            int index = Arrays.binarySearch(dp, 0, len, num);
            // If not found, binarySearch returns (-(insertion point) - 1), so we calculate the correct index
            if (index < 0) index = -(index + 1);
            dp[index] = num;

            // If index == len, it means num is larger than any element in dp, so we extend the subsequence
            if (index == len) len++;
        }

        return len;
    }
}
