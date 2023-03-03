package merge_intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 4}, {4, 5}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{1, 5}};
        Assertions.assertArrayEquals(expect, actual);
    }

//    @Test
//    public void test_case3_success() {
//        Solution s = new Solution();
//        int[][] input = new int[][]{{1, 4}, {5, 6}, {4, 7}};
//        int[][] actual = s.merge(input);
//        int[][] expect = new int[][]{{1, 7}};
//        Assertions.assertArrayEquals(expect, actual);
//    }

    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 3}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{1, 3}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case5_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 4}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{1, 4}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case6_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 4}, {0, 4}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{0, 4}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case7_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 4}, {0, 5}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{0, 5}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case8_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 4}, {2, 3}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{1, 4}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case9_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 4}, {0, 0}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{0, 0}, {1, 4}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case10_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 4}, {0, 1}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{0, 4}};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void test_case11_success() {
        Solution s = new Solution();
        int[][] input = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        int[][] actual = s.merge(input);
        int[][] expect = new int[][]{{0, 5}};
        Assertions.assertArrayEquals(expect, actual);
    }
}
