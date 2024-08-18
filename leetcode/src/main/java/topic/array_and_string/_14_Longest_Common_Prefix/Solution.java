package topic.array_and_string._14_Longest_Common_Prefix;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as the initial prefix
        String prefix = strs[0];

        // Iterate over the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // Shorten the prefix until it matches the beginning of the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If we reduce the prefix to an empty string
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
