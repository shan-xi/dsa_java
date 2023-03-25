package binary_tree_postorder_traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 145. Binary Tree Postorder Traversal
public class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return result;
    }

    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        result.add(root.val);
    }
}
