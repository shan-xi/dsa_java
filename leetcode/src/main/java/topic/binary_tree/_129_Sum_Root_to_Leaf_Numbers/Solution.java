package topic.binary_tree._129_Sum_Root_to_Leaf_Numbers;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int sum = solution.sumNumbers(root);
        System.out.println("Sum of all root-to-leaf numbers: " + sum);
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        // If the node is a leaf, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recur for left and right subtrees and return the sum
        return sumNumbersHelper(node.left, currentSum) + sumNumbersHelper(node.right, currentSum);
    }
}
