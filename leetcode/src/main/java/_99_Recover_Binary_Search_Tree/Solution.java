package _99_Recover_Binary_Search_Tree;

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

public class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public static void main(String[] args) {
        var s = new Solution();
        var root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        s.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);

        var temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }

}
