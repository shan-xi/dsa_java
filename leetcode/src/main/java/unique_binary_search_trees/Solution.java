package unique_binary_search_trees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numTrees(int n) {
        /**
         * n = 1 -> 1
         * n = 2 -> 2
         * n = 3 -> 5 => n[2] + n[1]*n[1] + n[2] = 2 + 1 + 2 = 5
         * n = 4 -> 14 => n[3] + n[1]*n[2] + n[2]*n[1] + n[3] = 5 + 2 + 2 + 5 = 14
         * n = 5 -> 42 => n[4] + n[1]*n[3] + n[2]*n[2] + n[3]*n[1] + n[4] = 14 + 5 + 4 + 5 + 14 = 42
         */

        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += f[j] * f[i - j - 1];
            }
            f[i] = sum;
        }
        return f[n];
    }

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int root = start; root <= end; root++) {
            List<TreeNode> leftTrees = helper(start, root - 1);
            List<TreeNode> rightTrees = helper(root + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(root, left, right);
                    list.add(node);
                }
            }
        }
        return list;
    }

    public void printByPreorder(List<TreeNode> nodeList) {
        for (TreeNode root : nodeList) {
            preorder(root);
            System.out.println();
        }
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "root=" + this.val + ", left=" + this.left + ", right=" + this.right;
    }
}