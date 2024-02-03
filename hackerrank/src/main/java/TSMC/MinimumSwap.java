package TSMC;

import java.util.Stack;

/**
 * 這個問題要求我們找出將一串由左括號 '(' 和右括號 ')' 組成的序列轉換成平衡序列所需的最少交換次數。
 * 一個平衡的括號序列是指每一個左括號都有一個對應的右括號與之匹配。
 * 更具體地說，一個平衡的括號序列可以表示為 s1(s2)，其中 s1 和 s2 要麼是空的，要麼是平衡的字符串。如果無法使序列平衡，則返回 -1。
 */

public class MinimumSwap {

    public static int minSwaps(String s) {

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (var c : s.toCharArray()) {
            if (c == '(') {
                leftStack.push(c);
            } else {
                if (!leftStack.isEmpty() && leftStack.peek() == '(') {
                    leftStack.pop();
                } else {
                    rightStack.push(c);
                }
            }
        }
        if (leftStack.size() != rightStack.size()) {
            return -1;
        }
        return (leftStack.size() + rightStack.size()) / 2;
    }

    public static void main(String[] args) {
        if (minSwaps("(()))(") != 1) {
            System.out.println("error-1");
        }
        if (minSwaps("(()))") != -1) {
            System.out.println("error-2");
        }
        if (minSwaps("(())))))((((") != 4) {
            System.out.println("error-3");
        }
        if (minSwaps("((((") != -1) {
            System.out.println("error-4");
        }
        if (minSwaps("))))") != -1) {
            System.out.println("error-5");
        }
        if (minSwaps("(((())))") != 0) {
            System.out.println("error-6");
        }
        if (minSwaps(")(") != 1) {
            System.out.println("error-7");
        }
        if (minSwaps("))((") != 2) {
            System.out.println("error-8");
        }
        if (minSwaps("(()())") != 0) {
            System.out.println("error-9");
        }
    }
}
