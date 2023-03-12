package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortDemoTest {
    @Test
    public void test_case1_success() {
        MergeSortDemo m = new MergeSortDemo();
        int[] arr = {5, 2, 8, 3, 1, 6, 9, 7, 4};
        m.mergeSort(arr);
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(expect, arr);
    }
    @Test
    public void test_case2_success() {
        MergeSortDemo m = new MergeSortDemo();
        int[] arr = {5};
        m.mergeSort(arr);
        int[] expect = {5};
        Assertions.assertArrayEquals(expect, arr);
    }
}
