package ransom_note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        boolean a = s.canConstruct("a", "b");
        boolean e = false;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        boolean a = s.canConstruct("aa", "ab");
        boolean e = false;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        boolean a = s.canConstruct("aa", "aab");
        boolean e = true;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        boolean a = s.canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj");
        boolean e = true;
        Assertions.assertEquals(e, a);
    }
}
