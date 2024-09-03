package topic.binary_search._230_Kth_Smallest_Element_in_a_BST;

public class Solution {
    private int count = 0;
    private int result = Integer.MIN_VALUE;

    // Main function for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        System.out.println(solution.kthSmallest(root1, 1)); // Output: 1

        // Test Case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        System.out.println(solution.kthSmallest(root2, 3)); // Output: 3
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
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
