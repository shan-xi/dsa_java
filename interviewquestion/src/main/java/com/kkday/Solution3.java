package com.kkday;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int solution(String S) {

        char[] ca = S.toCharArray();
        // use to temp save the original char value for loop to change digit
        char originValue = 0;
        // use to keep not duplicate values
        Set<Integer> countSet = new HashSet<>();
        // loop through all char value to check different digit
        for (int i = 0; i < S.length(); i++) {
            originValue = ca[i];
            // loop through 0 ~ 9
            for (int j = 0; j <= 9; j++) {
                ca[i] = (char) (j + '0');
                String ns = String.valueOf(ca);
                int newInt = Integer.parseInt(ns);
                if (newInt % 3 == 0) {
                    // make sure no duplicate value
                    countSet.add(newInt);
                }
                // reset to original value
                ca[i] = originValue;
            }
        }
        return countSet.size();
    }
}
