package binary_tree_level_order_traversal;

import common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        List<List<Integer>> a = s.levelOrder(n1);
        List<List<Integer>> e = List.of(List.of(3), List.of(9, 20), List.of(15, 7));
        Assertions.assertEquals(e, a);
    }
    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        List<List<Integer>> a = s.levelOrder(n1);
        List<List<Integer>> e = List.of(List.of(1));
        Assertions.assertEquals(e, a);
    }
    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        TreeNode n1 = null;
        List<List<Integer>> a = s.levelOrder(n1);
        List<List<Integer>> e = List.of();
        Assertions.assertEquals(e, a);
    }
    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        List<List<Integer>> a = s.levelOrder(n1);
        List<List<Integer>> e = List.of(List.of(1), List.of(2, 3), List.of(4, 5));
        Assertions.assertEquals(e, a);
    }
}
