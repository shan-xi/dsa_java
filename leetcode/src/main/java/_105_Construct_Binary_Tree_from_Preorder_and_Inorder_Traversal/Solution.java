package _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.HashMap;

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
}

class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        // Test case 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = s.buildTree(preorder1, inorder1);
        System.out.println("Test case 1:");
        printTree(root1);

        // Test case 2
        int[] preorder2 = {1, 2, 3};
        int[] inorder2 = {3, 2, 1};
        TreeNode root2 = s.buildTree(preorder2, inorder2);
        System.out.println("\nTest case 2:");
        printTree(root2);

        // Test case 3
        int[] preorder3 = {-1};
        int[] inorder3 = {-1};
        TreeNode root3 = s.buildTree(preorder3, inorder3);
        System.out.println("\nTest case 3:");
        printTree(root3);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        var indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return builderTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
    }

    private TreeNode builderTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> indexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        var rootVal = preorder[preStart];
        var root = new TreeNode(rootVal);

        var rootIndexInorder = indexMap.get(rootVal);
        var leftSubtreeSize = rootIndexInorder - inStart;

        root.left = builderTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndexInorder - 1, indexMap);
        root.right = builderTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndexInorder + 1, inEnd, indexMap);

        return root;
    }
}
