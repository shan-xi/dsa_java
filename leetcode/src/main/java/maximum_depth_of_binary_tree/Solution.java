package maximum_depth_of_binary_tree;

import common.TreeNode;

// 104. Maximum Depth of Binary Tree
public class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
