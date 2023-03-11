package minimum_path_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int actual = s.minPathSum(grid);
        int expect = 7;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        int actual = s.minPathSum(grid);
        int expect = 12;
        Assertions.assertEquals(expect, actual);
    }
}
