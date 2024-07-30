package topic.sliding_window._209_Minimum_Size_Subarray_Sum;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = solution.minSubArrayLen(target, nums);
        System.out.println("Minimum size subarray sum: " + result);  // Output: 2
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            sum += nums[end];

            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}