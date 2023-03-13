package number_of_islands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int a = s.numIsLands(grid);
        int e = 1;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int a = s.numIsLands(grid);
        int e = 3;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        int a = s.numIsLands(grid);
        int e = 1;
        Assertions.assertEquals(e, a);
    }
}
