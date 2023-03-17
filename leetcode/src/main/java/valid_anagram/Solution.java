package valid_anagram;

import java.util.Arrays;

// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/?envType=study-plan&id=data-structure-i
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (char c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
