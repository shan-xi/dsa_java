package topic.array_and_string._26_Remove_Duplicates_from_Sorted_Array;

public class Solution {
    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = solution.removeDuplicates(nums);

        System.out.println("Length of array after removing duplicates: " + length);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    //    my answer
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int p = 1;
        int c = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != c) {
                c = nums[i];
                nums[p++] = c;
            }
        }
        return p;
    }
//    public int removeDuplicates(int[] nums) {
//        // Edge case: if the array is empty, return 0
//        if (nums.length == 0) return 0;
//
//        // Initialize a pointer to store the position of the last unique element
//        int i = 0;
//
//        // Iterate through the array using the fast pointer
//        for (int j = 1; j < nums.length; j++) {
//            // If a new unique element is found, move it next to the last unique element
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//
//        // The length of the unique elements array is i + 1
//        return i + 1;
//    }
}
