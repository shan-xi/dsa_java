package com.kkday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3Test {
    @Test
    public void test_case1_success() {
        Solution3 s = new Solution3();
        int actual = s.solution("23");
        int expect = 7;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution3 s = new Solution3();
        int actual = s.solution("0081");
        int expect = 11;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution3 s = new Solution3();
        int actual = s.solution("022");
        int expect = 9;
        Assertions.assertEquals(expect, actual);
    }
}
