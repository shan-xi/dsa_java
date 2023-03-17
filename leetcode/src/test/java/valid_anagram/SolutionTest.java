package valid_anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        boolean a = s.isAnagram("anagram", "nagaram");
        boolean e = true;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        boolean a = s.isAnagram("rat", "car");
        boolean e = false;
        Assertions.assertEquals(e, a);
    }
}
