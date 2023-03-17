package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinHeapSortTest {

    @Test
    public void test_case1_success() {
        int[] arr = {3, 7, 1, 8, 2, 5, 9, 4, 6};
        MinHeapSort.sort(arr);
        int[] e = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Assertions.assertArrayEquals(e, arr);
    }
}
