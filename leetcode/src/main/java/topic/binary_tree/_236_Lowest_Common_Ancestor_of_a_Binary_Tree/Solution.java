package topic.binary_tree._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private TreeNode lca;

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Construct the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // 5
        TreeNode q = root.right; // 1

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of node 5 and 1 is: " + lca.val); // Expected output is 3
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return lca;
    }

    private boolean findLCA(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }

        // Search in left subtree
        boolean left = findLCA(currentNode.left, p, q);

        // Search in right subtree
        boolean right = findLCA(currentNode.right, p, q);

        // Check if current node is one of the targets
        boolean mid = (currentNode == p || currentNode == q);

        // If any two of the three flags left, right, mid are true, this node is the LCA
        if ((left && right) || (mid && left) || (mid && right)) {
            lca = currentNode;
        }

        // Return true if any one of the three flags is true
        return (mid || left || right);
    }
}

