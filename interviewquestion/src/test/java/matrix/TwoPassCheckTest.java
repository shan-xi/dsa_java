package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoPassCheckTest {
    @Test
    public void test_case1_success() {
        TwoPassCheck t = new TwoPassCheck();
        int actual = t.solution(new int[][]{
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 1, 0}
        });
        int expect = 5;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case2_success() {
        TwoPassCheck t = new TwoPassCheck();
        int actual = t.solution(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        });
        int expect = 12;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case3_success() {
        TwoPassCheck t = new TwoPassCheck();
        int actual = t.solution(new int[][]{
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1}
        });
        int expect = 9;
        Assertions.assertEquals(expect, actual);
    }
}
