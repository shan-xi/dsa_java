package merge_sorted_array;

//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/description/
public class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (n == 0) {
//            return;
//        }
//
//        for (int i = m; i < nums1.length; i++) {
//            nums1[i] = nums2[i - m];
//
//            int k = i;
//            while ((k - 1) >= 0 && (nums1[k] < nums1[k - 1])) {
//                int temp = nums1[k];
//                nums1[k] = nums1[k - 1];
//                nums1[k - 1] = temp;
//                k--;
//            }
//        }
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }

}
