package topic.binary_tree._199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // Main function for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println(solution.rightSideView(root1)); // Output: [1, 3, 4]

        // Test Case 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(solution.rightSideView(root2)); // Output: [1, 3]

        // Test Case 3
        TreeNode root3 = null;
        System.out.println(solution.rightSideView(root3)); // Output: []
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) return rightView;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = null;

            for (int i = 0; i < levelSize; i++) {
                currentNode = queue.poll();

                assert currentNode != null;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            // The last node in the current level is the rightmost node
            rightView.add(currentNode.val);
        }

        return rightView;
    }

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
