package com.kkday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2Test {
    @Test
    public void test_case1_success() {
        Solution2 s = new Solution2();
        int actual = s.solution(new int[]{1, 2, 5, 9, 9}, 5);
        int expect = 2;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case3_success() {
        Solution2 s = new Solution2();
        int actual = s.solution(new int[]{1, 2, 5, 9, 9}, 1);
        int expect = 0;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case4_success() {
        Solution2 s = new Solution2();
        int actual = s.solution(new int[]{1, 2, 5, 9, 9}, 2);
        int expect = 1;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case2_success() {
        Solution2 s = new Solution2();
        int actual = s.solution(new int[]{}, 0);
        int expect = -1;
        Assertions.assertEquals(expect, actual);
    }
}
