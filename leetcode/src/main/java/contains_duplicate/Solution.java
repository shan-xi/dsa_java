package contains_duplicate;

import java.util.HashSet;
import java.util.Set;

//217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/?envType=study-plan&id=data-structure-i
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return true;
            }
        }
        return false;
    }
}
