package _402_Remove_K_Digits;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.removeKdigits("1432219", 3)); // 1219
        System.out.println(s.removeKdigits("10200", 1)); // 200
        System.out.println(s.removeKdigits("10", 2)); // 0
        System.out.println(s.removeKdigits("1234567890", 9)); // 0
    }

    public String removeKdigits(String num, int k) {
        int len = num.length();
        int i = 0;
        if (k == len) return "0";
        if (k == 0) return num;
        var stack = new Stack<Character>();
        while (i < len) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}