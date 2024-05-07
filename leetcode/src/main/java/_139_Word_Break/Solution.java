package _139_Word_Break;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(solution.wordBreak(s, wordDict)); // Output: true

        s = "applepenapple";
        wordDict = Arrays.asList("apple", "pen");
        System.out.println(solution.wordBreak(s, wordDict)); // Output: true

        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(solution.wordBreak(s, wordDict)); // Output: false
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        var wordDictSet = new HashSet<>(wordDict);
        var dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
