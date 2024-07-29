package topic.binary_search._704_Binary_Search;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);  // Output: 4

    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To avoid overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }
}