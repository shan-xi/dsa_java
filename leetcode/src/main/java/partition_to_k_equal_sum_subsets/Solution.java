package partition_to_k_equal_sum_subsets;


import java.util.Arrays;

//698. Partition to K Equal Sum Subsets
//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        reverseArray(nums);
        return backtrack(visited, nums, 0, k, 0, sum / k);
    }

    private void reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private boolean backtrack(boolean[] visited, int[] nums, int start, int k, int currSum, int target) {
        if (k == 1) {
            return true;
        }
        if (currSum == target) {
            return backtrack(visited, nums, 0, k - 1, 0, target);
        }
        for (int i = start; i < visited.length; i++) {
            if (!visited[i] && currSum + nums[i] <= target) {
                visited[i] = true;
                if (backtrack(visited, nums, i + 1, k, currSum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}

