package topic.dp._139_Word_Break;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = Arrays.asList("leet", "code");
        String s = "leetcode";
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println("Can the string \"" + s + "\" be segmented? " + result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // Convert wordDict to a set for fast look-up
        int maxWordLength = 0;  // Find the longest word in the dictionary
        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // Base case: An empty string can be segmented

        // Iterate over all substrings of s
        for (int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(0, i - maxWordLength); j < i; j++) {
                // If the substring s[j:i] is in wordSet and dp[j] is true (means s[0:j] can be segmented)
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];  // Return whether the entire string can be segmented
    }
}
