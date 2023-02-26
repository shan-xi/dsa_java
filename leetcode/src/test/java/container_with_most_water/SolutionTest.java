package container_with_most_water;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int actual = s.maxArea(new int[]{1, 1});
        int expect = 1;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int actual = s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int expect = 49;
        Assertions.assertEquals(expect, actual);
    }
}
