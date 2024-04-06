package steller.cyber;

import java.util.HashMap;

/**
 * Question
 * Calculate the top 3 words in a body of text.
 * <p>
 * Input:
 * “Hello world. This is some sample text. Text is short and simple.”
 * <p>
 * Output:
 * { “is”: 2, “text”: 2, “hello”: 1 }
 * <p>
 * Code:
 * <Write your code here or if you prefer using your IDE: please screen share>
 * <You may use any language>
 * <If you need to consult material: that is acceptable but please let me know>
 */
public class Solution {
    public static void main(String[] args) {
        var input = "Hello world. This is some sample text. Text is short and simple.";

        // O(k)
        var arr = input.split(" ");

        // O(m)
        var map = new HashMap<String, Integer>();

        // O(n)
        for (var w : arr) {
            var key = w.toLowerCase().replace(".", "");
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            map.put(key, map.get(key) + 1);
        }
        // O(n log n)
        map.entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .limit(3)
                .forEach(System.out::println);

        // time complex : O(n log n)
        // memory complex : O(m+k)
    }
}
