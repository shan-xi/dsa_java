package fibonacci_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int a = s.fib(2);
        int e = 1;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int a = s.fib(3);
        int e = 2;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int a = s.fib(4);
        int e = 3;
        Assertions.assertEquals(e, a);
    }
}
