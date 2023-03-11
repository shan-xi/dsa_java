package binary_tree_preorder_traversal;

import common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> actual = s.preorderTraversal(root);
        List<Integer> expect = List.of(1, 2, 3);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        TreeNode root = null;
        List<Integer> actual = s.preorderTraversal(root);
        List<Integer> expect = new ArrayList<>();
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        List<Integer> actual = s.preorderTraversal(root);
        List<Integer> expect = List.of(1);
        Assertions.assertEquals(expect, actual);
    }
}
