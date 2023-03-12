package maximum_subarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int actual = s.maxSubArray(arr);
        int expect = 6;
        Assertions.assertEquals(expect, actual);
        actual = s.maxSubArrayDivideAndConquer(arr);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[] arr = {1};
        int actual = s.maxSubArray(arr);
        int expect = 1;
        Assertions.assertEquals(expect, actual);
        actual = s.maxSubArrayDivideAndConquer(arr);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[] arr = {5, 4, -1, 7, 8};
        int actual = s.maxSubArray(arr);
        int expect = 23;
        Assertions.assertEquals(expect, actual);
        actual = s.maxSubArrayDivideAndConquer(arr);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        int[] arr = {-1};
        int actual = s.maxSubArray(arr);
        int expect = -1;
        Assertions.assertEquals(expect, actual);
        actual = s.maxSubArrayDivideAndConquer(arr);
        Assertions.assertEquals(expect, actual);
    }
}
