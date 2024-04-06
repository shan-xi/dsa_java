package nth_tribonacci_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int a = s.tribonacci(4);
        int e = 4;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int a = s.tribonacci(25);
        int e = 1389537;
        Assertions.assertEquals(e, a);
    }
}
