package com.kkday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int actual = s.solution("BILLOBILLOLLOBBI", new String[]{"BILL", "BOB"});
        int expect = 3;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int actual = s.solution("CAT", new String[]{"ILOVEMYDOG", "CATS"});
        int expect = 0;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int actual = s.solution("ABCDXYZ", new String[]{"ABCD", "XYZ"});
        int expect = 1;
        Assertions.assertEquals(expect, actual);
    }
}
