package _187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); // ["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAAAA")); // ["AAAAAAAAAA"]
    }

    public List<String> findRepeatedDnaSequences(String s) {
        var result = new ArrayList<String>();
        if (s.length() <= 10) {
            return result;
        }
        var map = new HashMap<String, Integer>();
        for (int i = 0; i <= s.length() - 10; i++) {
            var sequence = s.substring(i, i + 10);
            map.put(sequence, map.getOrDefault(sequence, 0) + 1);
            if (map.get(sequence) == 2) {
                result.add(sequence);
            }
        }
        return result;
    }
}
