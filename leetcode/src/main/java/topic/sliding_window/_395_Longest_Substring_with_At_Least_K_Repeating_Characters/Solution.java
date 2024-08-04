package topic.sliding_window._395_Longest_Substring_with_At_Least_K_Repeating_Characters;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring("aaa", 3));  // Output: 3
//        System.out.println(solution.longestSubstring("aaabb", 3));  // Output: 3
//        System.out.println(solution.longestSubstring("ababbc", 2)); // Output: 5
    }

    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            int[] count = new int[26];
            int start = 0, end = 0, unique = 0, countAtLeastK = 0;

            while (end < n) {
                if (unique <= uniqueTarget) {
                    int endIndex = s.charAt(end) - 'a';
                    if (count[endIndex] == 0) unique++;
                    count[endIndex]++;
                    if (count[endIndex] == k) countAtLeastK++;
                    end++;
                } else {
                    int startIndex = s.charAt(start) - 'a';
                    if (count[startIndex] == k) countAtLeastK--;
                    count[startIndex]--;
                    if (count[startIndex] == 0) unique--;
                    start++;
                }

                if (unique == uniqueTarget && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, end - start);
                }
            }
        }
        return maxLen;
    }
}
