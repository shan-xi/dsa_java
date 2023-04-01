package invert_binary_tree;

import common.TreeNode;

// 226. Invert Binary Tree
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTreeHelper(root);
        return root;
    }

    private void invertTreeHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }

}
