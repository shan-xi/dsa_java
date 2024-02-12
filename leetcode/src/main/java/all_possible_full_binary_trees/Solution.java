package all_possible_full_binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public static void main(String[] args) {
        List<TreeNode> result = new Solution().allPossibleFBT(7);
        for (TreeNode r : result) {
            TreeNode.printTree(r);
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) {
            return result;
        }
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            result.add(root);
            return result;
        }
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftTreeNodes = allPossibleFBT(i);
            List<TreeNode> rightTreeNodes = allPossibleFBT(n - 1 - i);
            for (TreeNode leftTreeNode : leftTreeNodes) {
                for (TreeNode rightTreeNode : rightTreeNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftTreeNode;
                    root.right = rightTreeNode;
                    result.add(root);
                }
            }
        }
        return result;
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

    // Function to print the binary tree as [0,0,0,null,null,0,0,null,null,0,0]
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                values.add(String.valueOf(current.val));
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                values.add("null");
            }
        }

        // Trim trailing nulls
        int endIndex = values.size() - 1;
        while (endIndex >= 0 && values.get(endIndex).equals("null")) {
            endIndex--;
        }

        System.out.println(values.subList(0, endIndex + 1));
    }
}