package valid_parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        boolean a = s.isValid("()");
        boolean e = true;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        boolean a = s.isValid("()[]{}");
        boolean e = true;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        boolean a = s.isValid("(]");
        boolean e = false;
        Assertions.assertEquals(e, a);
    }
}
