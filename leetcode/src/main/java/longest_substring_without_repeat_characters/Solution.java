package longest_substring_without_repeat_characters;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128];
        int right = 0;
        int left = 0;
        int res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            Integer index = chars[c];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }
            res = Math.max(res, right - left + 1);
            chars[c] = right;
            right++;
        }

        return res;
    }
}