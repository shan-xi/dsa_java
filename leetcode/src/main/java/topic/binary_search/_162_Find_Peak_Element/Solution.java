package topic.binary_search._162_Find_Peak_Element;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple array
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak Index (Test 1): " + solution.findPeakElement(nums1));

        // Test case 2: Multiple peaks
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak Index (Test 2): " + solution.findPeakElement(nums2));

        // Test case 3: All decreasing
        int[] nums3 = {4, 3, 2, 1};
        System.out.println("Peak Index (Test 3): " + solution.findPeakElement(nums3));

        // Test case 4: Single element
        int[] nums4 = {1};
        System.out.println("Peak Index (Test 4): " + solution.findPeakElement(nums4));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is on the left side (including mid)
                right = mid;
            } else {
                // Peak is on the right side
                left = mid + 1;
            }
        }
        // left will eventually point to a peak element
        return left;
    }
}
