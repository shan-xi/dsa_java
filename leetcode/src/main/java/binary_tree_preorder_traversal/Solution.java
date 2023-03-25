package binary_tree_preorder_traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 144. Binary Tree Preorder Traversal
public class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
