package maximum_depth_of_binary_tree;

import common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        Solution s = new Solution();
        int a = s.maxDepth(n1);
        Assertions.assertEquals(3, a);
    }

    @Test
    public void test_case2_success() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.right = n2;
        Solution s = new Solution();
        int a = s.maxDepth(n1);
        Assertions.assertEquals(2, a);
    }
}
