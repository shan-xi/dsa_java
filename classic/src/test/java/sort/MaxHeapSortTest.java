package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxHeapSortTest {
    @Test
    public void test_case1_success() {
        int[] arr = {3, 7, 1, 8, 2, 5, 9, 4, 6};
        MaxHeapSort.sort(arr);
        int[] e = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(e, arr);
    }
}
