package topic.bit_manipulation._137_Single_Number_II;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {2, 2, 3, 2};
        System.out.println("Test case 1: " + solution.singleNumber(nums1));  // Expected output: 3

        // Test case 2
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Test case 2: " + solution.singleNumber(nums2));  // Expected output: 99

        // Test case 3
        int[] nums3 = {30000, 500, 100, 30000, 100, 30000, 100};
        System.out.println("Test case 3: " + solution.singleNumber(nums3));  // Expected output: 500

        // Test case 4
        int[] nums4 = {-2, -2, 1, -2};
        System.out.println("Test case 4: " + solution.singleNumber(nums4));  // Expected output: 1
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // 'ones' will only have bits that have appeared once
            ones = (ones ^ num) & ~twos;

            // 'twos' will only have bits that have appeared twice
            twos = (twos ^ num) & ~ones;
        }

        // 'ones' contains the bits of the single number
        return ones;
    }
}
