package _29_Divide_Two_Integers;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10, 3));  // Output: 3
        System.out.println(s.divide(7, -3));  // Output: -2
        System.out.println(s.divide(0, 1));   // Output: 0
        System.out.println(s.divide(1, 1));   // Output: 1
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend > 0) ^ (divisor > 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int quotient = 0;

        while (dividend <= divisor) {
            int tempDivisor = divisor;
            int multiple = 1;
            while (dividend - tempDivisor <= tempDivisor) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            dividend -= tempDivisor;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}