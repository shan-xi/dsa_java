package topic.array_and_string._12_Integer_to_Roman._27_Remove_Element;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] case1 = new int[]{3, 2, 2, 3};
        int[] case2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(s.removeElement(case1, 3));
        System.out.println(Arrays.toString(case1));
        System.out.println(s.removeElement(case2, 2));
        System.out.println(Arrays.toString(case2));
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;  // Pointer to track the place for the next non-val element

        // Iterate over the array
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];  // Move non-val element to the front
                i++;  // Increment the position for the next element
            }
        }
        return i;  // Return the number of non-val elements
    }
}
