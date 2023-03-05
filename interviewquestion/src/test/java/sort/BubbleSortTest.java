package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {
    @Test
    public void test_case1_success() {
        int[] arr = {-2, 45, 0, 11, -9};
        BubbleSort.sort(arr);
        Assertions.assertArrayEquals(new int[]{-9, -2, 0, 11, 45}, arr);
    }
}
