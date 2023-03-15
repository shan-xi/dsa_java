package pascals_triangle;

import java.util.ArrayList;
import java.util.List;

// 118. Pascal's Triangle
// https://leetcode.com/problems/pascals-triangle/?envType=study-plan&id=data-structure-i
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                r.add(List.of(1));
            } else if (i == 1) {
                r.add(List.of(1, 1));
            } else {
                List<Integer> prev = r.get(i-1);
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(1);
                for (int t = 1; t < i; t++) {
                    temp.add(prev.get(t-1)+prev.get(t));
                }
                temp.add(1);
                r.add(temp);
            }
        }
        return r;
    }
}
