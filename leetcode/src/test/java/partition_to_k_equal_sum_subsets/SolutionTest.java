package partition_to_k_equal_sum_subsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        boolean actual = s.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
        boolean expect = true;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        boolean actual = s.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3);
        boolean expect = false;
        Assertions.assertEquals(expect, actual);
    }
}
