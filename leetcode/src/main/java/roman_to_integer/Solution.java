package roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] ca = s.toCharArray();
        int sum = 0;
        for(int i=0;i<ca.length;i++){
            char c = ca[i];
            if (c == 'I') {
                if (i < ca.length - 1 && (ca[i + 1] == 'V' || ca[i + 1] == 'X')) {
                    sum += map.get(ca[i + 1]) - map.get(c);
                    i++;
                } else {
                    sum += map.get(c);
                }
            } else if (c == 'X') {
                if (i < ca.length - 1 && (ca[i + 1] == 'L' || ca[i + 1] == 'C')) {
                    sum += map.get(ca[i + 1]) - map.get(c);
                    i++;
                } else {
                    sum += map.get(c);
                }
            } else if (c == 'C') {
                if (i < ca.length - 1 && (ca[i + 1] == 'D' || ca[i + 1] == 'M')) {
                    sum += map.get(ca[i + 1]) - map.get(c);
                    i++;
                } else {
                    sum += map.get(c);
                }
            } else {
                sum += map.get(c);
            }
        }
        return sum;
    }
}
