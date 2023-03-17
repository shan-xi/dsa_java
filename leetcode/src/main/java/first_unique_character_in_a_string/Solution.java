package first_unique_character_in_a_string;

// 387. First Unique Character in a String
// https://leetcode.com/problems/first-unique-character-in-a-string/description/?envType=study-plan&id=data-structure-i
public class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
