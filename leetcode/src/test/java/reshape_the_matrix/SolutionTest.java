package reshape_the_matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int[][] a = s.matrixReshape(mat, r, c);
        int[][] e = {{1, 2, 3, 4}};
        Assertions.assertArrayEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 2;
        int c = 4;
        int[][] a = s.matrixReshape(mat, r, c);
        int[][] e = {{1, 2}, {3, 4}};
        Assertions.assertArrayEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 4;
        int c = 1;
        int[][] a = s.matrixReshape(mat, r, c);
        int[][] e = {{1}, {2}, {3}, {4}};
        Assertions.assertArrayEquals(e, a);
    }
}
