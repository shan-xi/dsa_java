package topic.math._172_Factorial_Trailing_Zeroes;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: n = 5
        int n1 = 5;
        System.out.println("Trailing zeroes in " + n1 + "! : " + solution.trailingZeroes(n1));  // Output: 1

        // Test case 2: n = 10
        int n2 = 10;
        System.out.println("Trailing zeroes in " + n2 + "! : " + solution.trailingZeroes(n2));  // Output: 2

        // Test case 3: n = 25
        int n3 = 25;
        System.out.println("Trailing zeroes in " + n3 + "! : " + solution.trailingZeroes(n3));  // Output: 6

        // Test case 4: n = 100
        int n4 = 100;
        System.out.println("Trailing zeroes in " + n4 + "! : " + solution.trailingZeroes(n4));  // Output: 24
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
