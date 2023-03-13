package two_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[] actual = s.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] expect = {0, 1};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[] actual = s.twoSum(new int[]{3, 2, 4}, 6);
        int[] expect = {1, 2};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[] actual = s.twoSum(new int[]{3, 3}, 6);
        int[] expect = {0, 1};
        Assertions.assertArrayEquals(expect, actual);
    }
}
