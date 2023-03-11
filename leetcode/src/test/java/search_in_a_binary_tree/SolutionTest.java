package search_in_a_binary_tree;

import common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n1 = new TreeNode(2, n3, n4);
        TreeNode n2 = new TreeNode(7);
        TreeNode root = new TreeNode(4, n1, n2);
        TreeNode actual = s.searchBST(root, 2);
        TreeNode expect = n1;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n1 = new TreeNode(2, n3, n4);
        TreeNode n2 = new TreeNode(7);
        TreeNode root = new TreeNode(4, n1, n2);
        TreeNode actual = s.searchBST(root, 7);
        TreeNode expect = n2;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n1 = new TreeNode(2, n3, n4);
        TreeNode n2 = new TreeNode(7);
        TreeNode root = new TreeNode(4, n1, n2);
        TreeNode actual = s.searchBST(root, 5);
        TreeNode expect = null;
        Assertions.assertEquals(expect, actual);
    }
}
