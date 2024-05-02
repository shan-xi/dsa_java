package _31_Next_Permutation;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        var d1 = new int[]{1, 2, 3};
        s.nextPermutation(d1);
        System.out.println(Arrays.toString(d1)); // 1 3 2
        var d2 = new int[]{3, 2, 1};
        s.nextPermutation(d2);
        System.out.println(Arrays.toString(d2)); // 1 2 3
        var d3 = new int[]{1, 1, 5};
        s.nextPermutation(d3);
        System.out.println(Arrays.toString(d3)); // 1 5 1
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
