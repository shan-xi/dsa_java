package path_sum;

import common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.right = n9;
        Solution s = new Solution();
        boolean a = s.hasPathSum(n1, 22);
        Assertions.assertTrue(a);
    }

    @Test
    public void test_case2_success() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        Solution s = new Solution();
        boolean a = s.hasPathSum(n1, 5);
        Assertions.assertFalse(a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        boolean a = s.hasPathSum(null, 0);
        Assertions.assertFalse(a);
    }
}
