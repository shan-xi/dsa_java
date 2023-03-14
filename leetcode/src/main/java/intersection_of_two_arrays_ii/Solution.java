package intersection_of_two_arrays_ii;

import java.util.Arrays;

//350. Intersection of Two Arrays II
//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            } else {
                if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
