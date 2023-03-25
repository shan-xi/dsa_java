package binary_tree_postorder_traversal;

import common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        Solution s = new Solution();
        List<Integer> a = s.postorderTraversal(n1);
        List<Integer> e = List.of(3, 2, 1);
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        List<Integer> a = s.postorderTraversal(null);
        List<Integer> e = new ArrayList<>();
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        TreeNode n1 = new TreeNode(1);
        Solution s = new Solution();
        List<Integer> a = s.postorderTraversal(n1);
        List<Integer> e = List.of(1);
        Assertions.assertEquals(e, a);
    }
}
