package topic.math._50_Pow_x_n;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: x = 2.0, n = 10
        double x1 = 2.0;
        int n1 = 10;
        System.out.println("2.0^10: " + solution.myPow(x1, n1));  // Output: 1024.0

        // Test case 2: x = 2.1, n = 3
        double x2 = 2.1;
        int n2 = 3;
        System.out.println("2.1^3: " + solution.myPow(x2, n2));  // Output: 9.261

        // Test case 3: x = 2.0, n = -2
        double x3 = 2.0;
        int n3 = -2;
        System.out.println("2.0^-2: " + solution.myPow(x3, n3));  // Output: 0.25

        // Test case 4: x = 2.0, n = 0
        double x4 = 2.0;
        int n4 = 0;
        System.out.println("2.0^0: " + solution.myPow(x4, n4));  // Output: 1.0

        // Test case 5: x = 0.0, n = 2
        double x5 = 0.0;
        int n5 = 2;
        System.out.println("0.0^2: " + solution.myPow(x5, n5));  // Output: 0.0
    }

    public double myPow(double x, int n) {
        // Handle edge case where n is Integer.MIN_VALUE
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) return 1;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
