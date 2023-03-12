package contains_duplicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[] arr = {1, 2, 3, 1};
        boolean actual = s.containsDuplicate(arr);
        boolean expect = true;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[] arr = {1, 2, 3, 4};
        boolean actual = s.containsDuplicate(arr);
        boolean expect = false;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[] arr = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean actual = s.containsDuplicate(arr);
        boolean expect = true;
        Assertions.assertEquals(expect, actual);
    }
}
