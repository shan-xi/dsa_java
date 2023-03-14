package max_area_of_island;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int a = s.maxAreaOfIsland(grid);
        int e = 6;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int a = s.maxAreaOfIsland(grid);
        int e = 0;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        int a = s.maxAreaOfIsland(grid);
        int e = 4;
        Assertions.assertEquals(e, a);
    }
}
