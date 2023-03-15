package number_of_enclaves;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        Solution s = new Solution();
        int a = s.numEnclaves(grid);
        int e = 3;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        Solution s = new Solution();
        int a = s.numEnclaves(grid);
        int e = 0;
        Assertions.assertEquals(e, a);
    }
}
