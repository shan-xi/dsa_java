package topic.hash_table._1002_Find_Common_Characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] words1 = {"bella", "label", "roller"};
        System.out.println(solution.commonChars(words1)); // Output: [e, l, l]

        // Test case 2
        String[] words2 = {"cool", "lock", "cook"};
        System.out.println(solution.commonChars(words2)); // Output: [c, o]
    }

    public List<String> commonChars(String[] words) {
        // Initialize the frequency map with maximum values
        Map<Character, Integer> minFreqMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            minFreqMap.put(c, Integer.MAX_VALUE);
        }

        // Iterate over each word in the array
        for (String word : words) {
            // Count the frequency of each character in the current word
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }

            // Update the minimum frequency map
            for (char c = 'a'; c <= 'z'; c++) {
                if (charCountMap.containsKey(c)) {
                    minFreqMap.put(c, Math.min(minFreqMap.get(c), charCountMap.get(c)));
                } else {
                    minFreqMap.put(c, 0);
                }
            }
        }

        // Construct the result list based on the minimum frequency map
        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int count = minFreqMap.get(c);
            while (count > 0) {
                result.add(String.valueOf(c));
                count--;
            }
        }

        return result;
    }
}
