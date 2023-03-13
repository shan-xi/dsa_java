package flood_fill;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] actual = s.floodFill(image, sr, sc, color);
        int[][] expect = {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int sr = 0;
        int sc = 0;
        int color = 0;
        int[][] actual = s.floodFill(image, sr, sc, color);
        int[][] expect = {{0, 0, 0}, {0, 0, 0}};
        Assertions.assertArrayEquals(expect, actual);
    }
    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int sr = 1;
        int sc = 0;
        int color = 2;
        int[][] actual = s.floodFill(image, sr, sc, color);
        int[][] expect = {{2, 2, 2}, {2, 2, 2}};
        Assertions.assertArrayEquals(expect, actual);
    }
}
