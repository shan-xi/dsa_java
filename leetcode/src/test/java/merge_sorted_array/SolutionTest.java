package merge_sorted_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        s.merge(nums1, m, nums2, n);
        int[] expect = {1, 2, 2, 3, 5, 6};
        Assertions.assertArrayEquals(expect, nums1);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        s.merge(nums1, m, nums2, n);
        int[] expect = {1};
        Assertions.assertArrayEquals(expect, nums1);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        s.merge(nums1, m, nums2, n);
        int[] expect = {1};
        Assertions.assertArrayEquals(expect, nums1);
    }
}
