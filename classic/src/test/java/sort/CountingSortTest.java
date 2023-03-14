package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountingSortTest {
    @Test
    public void test_case1_success() {
        CountingSort c = new CountingSort();
        int[] arr = {2, 5, 8, -4, 1, 3};
        c.sort(arr);
        int[] expect = {-4, 1, 2, 3, 5, 8};
        Assertions.assertArrayEquals(expect, arr);
    }
}
