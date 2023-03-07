package find_all_duplicates_in_an_array;

import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i];
            if (idx < 0) {
                idx *= -1;
            }
            if (nums[idx - 1] < 0) {
                result.add(idx);
            } else {
                nums[idx - 1] *= -1;
            }
        }
        return result;
    }
}
