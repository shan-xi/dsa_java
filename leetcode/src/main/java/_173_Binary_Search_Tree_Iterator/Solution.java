package _173_Binary_Search_Tree_Iterator;

import java.util.Stack;

//Definition for a binary tree node.
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


class BSTIterator {

    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }

    public static void main(String[] args) {
        // Create a sample binary search tree
        //       7
        //      / \
        //     3   15
        //        /  \
        //       9   20
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Create BSTIterator object
        BSTIterator obj = new BSTIterator(root);

        System.out.println();

        // Test next() and hasNext() methods
        while (obj.hasNext()) {
            int param_1 = obj.next();
            System.out.println(param_1);  // Should print 3, 7, 9, 15, 20 in sequence
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        pushAllLeft(node.right);
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}