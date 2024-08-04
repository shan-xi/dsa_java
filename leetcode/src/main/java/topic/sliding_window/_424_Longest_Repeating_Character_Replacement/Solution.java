package topic.sliding_window._424_Longest_Repeating_Character_Replacement;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("ABAB", 2)); // Output: 4
        System.out.println(solution.characterReplacement("AABABBA", 1)); // Output: 4
    }

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            int endIndex = s.charAt(end) - 'A';
            count[endIndex]++;
            maxCount = Math.max(maxCount, count[endIndex]);

            // Check if the window is valid
            // (window size - maxCount) is the number of characters that need to be replaced
            while ((end - start + 1) - maxCount > k) {
                int startIndex = s.charAt(start) - 'A';
                count[startIndex]--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
