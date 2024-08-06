package topic.two_pointers._80_Remove_Duplicates_from_Sorted_Array_II;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int newLength1 = solution.removeDuplicates(nums1);
        System.out.println("New length: " + newLength1); // Output: 5
        for (int i = 0; i < newLength1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int newLength2 = solution.removeDuplicates(nums2);
        System.out.println("New length: " + newLength2); // Output: 7
        for (int i = 0; i < newLength2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int insertPos = 2; // Start from the third position
        for (int current = 2; current < nums.length; current++) {
            // Compare the current element with the element at insertPos-2
            if (nums[current] != nums[insertPos - 2]) {
                nums[insertPos] = nums[current];
                insertPos++;
            }
        }

        return insertPos;
    }
}