package topic.binary_search._34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Target exists and appears multiple times
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("Result (Test 1): [" + result1[0] + ", " + result1[1] + "]");

        // Test case 2: Target does not exist
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("Result (Test 2): [" + result2[0] + ", " + result2[1] + "]");

        // Test case 3: Target is the first element
        int[] nums3 = {1, 2, 3, 4, 5};
        int target3 = 1;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("Result (Test 3): [" + result3[0] + ", " + result3[1] + "]");

        // Test case 4: Single element in the array
        int[] nums4 = {2};
        int target4 = 2;
        int[] result4 = solution.searchRange(nums4, target4);
        System.out.println("Result (Test 4): [" + result4[0] + ", " + result4[1] + "]");
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;  // record potential first position
                right = mid - 1;  // move left to find the first occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;  // record potential last position
                left = mid + 1;  // move right to find the last occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
}