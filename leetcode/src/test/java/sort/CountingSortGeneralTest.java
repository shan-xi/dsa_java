package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountingSortGeneralTest {
    @Test
    public void test_case1_success() {
        CountingSortGeneral c = new CountingSortGeneral();
        int[] arr = {2, 5, 8, 4, 1, 3};
        c.sort(arr);
        int[] expect = {1, 2, 3, 4, 5, 8};
        Assertions.assertArrayEquals(expect, arr);
    }

    @Test
    public void test_case2_success() {
        CountingSortGeneral c = new CountingSortGeneral();
        int[] arr = {3, 7, 4, 6, 6, 3, 0, 3, 8, 6, 6, 9, 6, 2, 8};
        c.sort(arr);
        int[] expect = {0, 2, 3, 3, 3, 4, 6, 6, 6, 6, 6, 7, 8, 8, 9};
        Assertions.assertArrayEquals(expect, arr);
    }
}
