package pascals_triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test_cases1_success() {
        Solution s = new Solution();
        List<List<Integer>> a = s.generate(5);
        List<List<Integer>> e = List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
        );
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_cases2_success() {
        Solution s = new Solution();
        List<List<Integer>> a = s.generate(1);
        List<List<Integer>> e = List.of(
                List.of(1)
        );
        Assertions.assertEquals(e, a);
    }
}
