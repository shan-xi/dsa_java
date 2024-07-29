package topic.priority_queue._264_Ugly_Number_II;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;  // Example input
        System.out.println(solution.nthUglyNumber(n));  // Output the 10th ugly number
    }

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        /**
         * i = 9
         *
         * 6  4  2
         * 16 15 15
         *
         * 0 1 2 3 4 5 6 7 8  9
         * 1 0 0 0 0 0 0 0 0  0
         * 1 2 3 4 5 6 8 9 10 12
         *
         */

        for (int i = 1; i < n; i++) {
            int nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            ugly[i] = nextUglyNumber;

            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = ugly[i2] * 2;
            }

            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = ugly[i3] * 3;
            }

            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = ugly[i5] * 5;
            }
        }

        return ugly[n - 1];
    }
}
