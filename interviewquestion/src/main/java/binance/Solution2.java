package binance;

import java.util.Stack;

/**
 * Question
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Sample Input
 * "()[]{}"
 * "{[]}}”
 * <p>
 * Sample Output
 * true
 * false
 * <p>
 * <p>
 * Solution :
 * boolean isValid(String s){
 * }
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String input1 = "()[]{}";
        String input2 = "{[]}}";
        String input3 = "([{)]}";
        String input4 = "(((([[[[{{{{}}}}]]]]))))";

        System.out.println(solution.isValid(input1)); // true
        System.out.println(solution.isValid(input2)); // false
        System.out.println(solution.isValid(input3)); // true
        System.out.println(solution.isValid(input4)); // true
    }

    private static void check(Stack<Character> fromStack, Stack<Character> toStack, char value) {
        while (!fromStack.isEmpty()) {
            var tempC = fromStack.pop();
            if (value == ')' && tempC == '(' ||
                    value == ']' && tempC == '[' ||
                    value == '}' && tempC == '{') {
                break;
            } else {
                toStack.push(tempC);
            }
        }
    }

    public boolean isValid(String s) {

        var s1 = new Stack<Character>();
        var s2 = new Stack<Character>();
        var c = s.toCharArray();

        for (char value : c) {
            if (value == '(' || value == '[' || value == '{') {  // open
                s1.push(value);
            } else { // close
                if (s1.isEmpty() && s2.isEmpty()) return false;
                check(s1, s2, value);
                check(s2, s1, value);
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }
}
