package intersection_of_two_arrays_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] actual = s.intersect(nums1, nums2);
        int[] expect = {2, 2};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] actual = s.intersect(nums1, nums2);
        int[] expect = {4, 9};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {2, 1};
        int[] actual = s.intersect(nums1, nums2);
        int[] expect = {1, 2};
        Assertions.assertArrayEquals(expect, actual);
    }
}
