package roman_to_integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int actual = s.romanToInt("III");
        int expect = 3;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int actual = s.romanToInt("LVIII");
        int expect = 58;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int actual = s.romanToInt("MCMXCIV");
        int expect = 1994;
        Assertions.assertEquals(expect, actual);
    }
}
