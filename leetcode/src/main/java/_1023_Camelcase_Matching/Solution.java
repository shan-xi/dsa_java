package _1023_Camelcase_Matching;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(matches(query, pattern));
        }
        return result;
    }

    private static boolean matches(String query, String pattern) {
        int pIndex = 0;
        for (int qIndex = 0; qIndex < query.length(); qIndex++) {
            if (pIndex < pattern.length() && query.charAt(qIndex) == pattern.charAt(pIndex)) {
                pIndex++;
            } else if (Character.isUpperCase(query.charAt(qIndex))) {
                return false;
            }
        }
        return pIndex == pattern.length();
    }

    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> result = camelMatch(queries, pattern);
        System.out.println(result); // Output: [true, false, true, true, false]
    }
}
