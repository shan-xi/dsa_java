package topic.kadanes_algorithm._918_Maximum_Sum_Circular_Subarray;

public class Solution {

    // Main function for testing
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test case 1
        int[] nums1 = {1, -2, 3, -2};
        System.out.println("Max circular subarray sum: " + solver.maxSubarraySumCircular(nums1));  // Expected output: 3

        // Test case 2
        int[] nums2 = {5, -3, 5};
        System.out.println("Max circular subarray sum: " + solver.maxSubarraySumCircular(nums2));  // Expected output: 10

        // Test case 3
        int[] nums3 = {-3, -2, -3};
        System.out.println("Max circular subarray sum: " + solver.maxSubarraySumCircular(nums3));  // Expected output: -2
    }

    public int maxSubarraySumCircular(int[] nums) {
        // Step 1: Find the maximum sum subarray using Kadane's Algorithm (non-circular case)
        int maxKadane = kadane(nums);

        // Step 2: Find the minimum sum subarray
        int totalSum = 0;
        int minSum = nums[0];
        int currentMin = nums[0];

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            if (i > 0) {
                currentMin = Math.min(currentMin + nums[i], nums[i]);
                minSum = Math.min(minSum, currentMin);
            }
        }

        // Step 3: If all elements are negative, return the maximum element (Kadane's result)
        if (totalSum == minSum) {
            return maxKadane;
        }

        // Step 4: Calculate the circular sum as totalSum - minSum
        int maxCircular = totalSum - minSum;

        // Step 5: Return the maximum of non-circular and circular results
        return Math.max(maxKadane, maxCircular);
    }

    // Helper function to perform Kadane's algorithm (for maximum subarray sum)
    private int kadane(int[] nums) {
        int maxSum = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentMax);
        }

        return maxSum;
    }
}
