package first_unique_character_in_a_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int a = s.firstUniqChar("leetcode");
        int e = 0;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int a = s.firstUniqChar("loveleetcode");
        int e = 2;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int a = s.firstUniqChar("aabb");
        int e = -1;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        int a = s.firstUniqChar("dddccdbba");
        int e = 8;
        Assertions.assertEquals(e, a);
    }
}
