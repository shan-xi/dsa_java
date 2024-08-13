package topic.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map to store the grouped anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Create a frequency array for the current string
            char[] charCounts = new char[26]; // Array for 26 lowercase letters

            // Count the frequency of each character
            for (char c : str.toCharArray()) {
                charCounts[c - 'a']++;
            }

            // Convert frequency array to a string key
            String key = new String(charCounts);

            // Group the string with its corresponding anagram group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Return all the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}
