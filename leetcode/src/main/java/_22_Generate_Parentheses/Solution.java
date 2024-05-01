package _22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.generateParenthesis(3));//["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(s.generateParenthesis(1));//["()"]
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }
}