package fibonacci_number;

// 509. Fibonacci Number
// https://leetcode.com/problems/fibonacci-number/?envType=study-plan&id=dynamic-programming-i
public class Solution {
    public int fib(int n) {
        int first = 0;
        int second = 1;
        if (n == 0) {
            return first;
        }
        if (n == 1) {
            return second;
        }
        int i = 2;
        while (i <= n) {
            int temp = second;
            second = first + second;
            first = temp;
            i++;
        }
        return second;
    }
}
