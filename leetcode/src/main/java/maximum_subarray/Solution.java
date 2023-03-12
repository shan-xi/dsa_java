package maximum_subarray;

//53. Maximum Subarray
//https://leetcode.com/problems/maximum-subarray/?envType=study-plan&id=data-structure-i
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int n : nums) {
            curSum = Math.max(n, curSum + n);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSum = maxSubArrayHelper(nums, left, mid);
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int crossSum = maxSybArrayCrossSum(nums, left, mid, right);
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int maxSybArrayCrossSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(sum, leftSum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(sum, rightSum);
        }

        return leftSum + rightSum;
    }
}
