package _17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(s.letterCombinations("")); // []
        System.out.println(s.letterCombinations("2")); // ["a","b","c"]
    }

    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, digits, mapping, 0, new StringBuffer());
        return result;
    }

    private void backtrack(List<String> result, String digits, String[] mapping, int index, StringBuffer current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        var letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(result, digits, mapping, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}