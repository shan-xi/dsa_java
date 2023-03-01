package integer_to_roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        String actual = s.intToRoman(3);
        String expect = "III";
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        String actual = s.intToRoman(58);
        String expect = "LVIII";
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        String actual = s.intToRoman(1994);
        String expect = "MCMXCIV";
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        String actual = s.intToRoman(3999);
        String expect = "MMMCMXCIX";
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case5_success() {
        Solution s = new Solution();
        String actual = s.intToRoman(10);
        String expect = "X";
        Assertions.assertEquals(expect, actual);
    }
}
