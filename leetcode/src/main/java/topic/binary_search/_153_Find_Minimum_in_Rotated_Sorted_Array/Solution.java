package topic.binary_search._153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Rotated sorted array
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Minimum element (Test 1): " + solution.findMin(nums1));

        // Test case 2: Another rotated sorted array
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element (Test 2): " + solution.findMin(nums2));

        // Test case 3: No rotation (already sorted)
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Minimum element (Test 3): " + solution.findMin(nums3));

        // Test case 4: Single element
        int[] nums4 = {1};
        System.out.println("Minimum element (Test 4): " + solution.findMin(nums4));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The minimum is in the right half
                left = mid + 1;
            } else {
                // The minimum is in the left half, including mid
                right = mid;
            }
        }

        return nums[left]; // left will point to the minimum element
    }
}
