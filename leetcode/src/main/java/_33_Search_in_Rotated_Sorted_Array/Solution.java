package _33_Search_in_Rotated_Sorted_Array;

class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(s.search(new int[]{1}, 0)); // -1
    }

    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
