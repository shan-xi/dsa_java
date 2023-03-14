package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountingSortSimpleTest {
    @Test
    public void test_case1_success() {
        CountingSortSimple c = new CountingSortSimple();
        int[] arr = {2, 5, 8, 4, 1, 3};
        c.sort(arr);
        int[] expect = {1, 2, 3, 4, 5, 8};
        Assertions.assertArrayEquals(expect, arr);
    }
}
