package topic.bit_manipulation._201_Bitwise_AND_of_Numbers_Range;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int left1 = 5;
        int right1 = 7;
        System.out.println("Bitwise AND of range [5, 7]: " + solution.rangeBitwiseAnd(left1, right1)); // Output: 4

        // Test case 2
        int left2 = 0;
        int right2 = 1;
        System.out.println("Bitwise AND of range [0, 1]: " + solution.rangeBitwiseAnd(left2, right2)); // Output: 0

        // Test case 3
        int left3 = 10;
        int right3 = 15;
        System.out.println("Bitwise AND of range [10, 15]: " + solution.rangeBitwiseAnd(left3, right3)); // Output: 8
    }

    public int rangeBitwiseAnd(int left, int right) {
        // Shift left and right until they are equal
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // Shift the common prefix back to its original position
        return left << shift;
    }
}
