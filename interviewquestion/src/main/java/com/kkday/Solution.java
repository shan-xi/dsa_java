package com.kkday;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String S, String [] L){
        int maxCopies = 0;
        // transform target S to char map for counting the number of char
        Map<Character, Integer> targetCount = new HashMap<Character, Integer>();
        for (char targetChar : S.toCharArray()) {
            if (targetCount.containsKey(targetChar)) {
                targetCount.put(targetChar, targetCount.get(targetChar) + 1);
            } else {
                targetCount.put(targetChar, 1);
            }
        }

        // for every sign in L to find maxCopies
        for (String sign : L) {
            Map<Character, Integer> signCount = new HashMap<Character, Integer>();
            boolean canBuild = true;
            // transform sign wording to char map for counting the number of char
            for (char signChar : sign.toCharArray()) {
                if (signCount.containsKey(signChar)) {
                    signCount.put(signChar, signCount.get(signChar) + 1);
                } else {
                    signCount.put(signChar, 1);
                }
            }

            // check if target value S can be replaced by the sign
            for (Map.Entry<Character, Integer> entry : signCount.entrySet()) {
                char signChar = entry.getKey();
                int count = entry.getValue();
                if (!targetCount.containsKey(signChar) || targetCount.get(signChar) < count) {
                    canBuild = false;
                    break;
                }
            }
            if (canBuild) {
                int tempCopies = Integer.MAX_VALUE;
                // should satisfy the minimum combination of sign
                for (Map.Entry<Character, Integer> entry : signCount.entrySet()) {
                    char signChar = entry.getKey();
                    int count = entry.getValue();
                    tempCopies = Math.min(tempCopies, targetCount.get(signChar) / count);
                }
                maxCopies = Math.max(maxCopies, tempCopies);
            }
        }
        return maxCopies;
    }
}
