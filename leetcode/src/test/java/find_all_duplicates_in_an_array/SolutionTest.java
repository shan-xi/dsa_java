package find_all_duplicates_in_an_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        List<Integer> actual = s.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        List<Integer> expect = List.of(2, 3);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        List<Integer> actual = s.findDuplicates(new int[]{1, 1, 2});
        List<Integer> expect = List.of(1);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        List<Integer> actual = s.findDuplicates(new int[]{1});
        List<Integer> expect = List.of();
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        List<Integer> actual = s.findDuplicates(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7});
        List<Integer> expect = List.of(10, 1);
        Assertions.assertEquals(expect, actual);
    }
}
