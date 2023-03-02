package unique_binary_search_trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void test_case1_successful() {
        Solution s = new Solution();
        int actual = s.numTrees(1);
        int expect = 1;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_successful() {
        Solution s = new Solution();
        int actual = s.numTrees(2);
        int expect = 2;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_successful() {
        Solution s = new Solution();
        int actual = s.numTrees(3);
        int expect = 5;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case4_successful() {
        Solution s = new Solution();
        int actual = s.numTrees(4);
        int expect = 14;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case5_successful() {
        Solution s = new Solution();
        List<TreeNode> r = s.generateTrees(3);
        s.printByPreorder(r);
    }
}
