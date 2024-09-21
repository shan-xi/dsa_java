package topic.divide_and_conquer._427_Construct_Quad_Tree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case: 4x4 grid
        int[][] grid = {
                {1, 0, 1, 1},
                {0, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 0}
        };

        Solution.Node root = solution.construct(grid);
        printQuadTree(root);
    }

    // Helper function to print the quad tree
    public static void printQuadTree(Solution.Node node) {
        if (node == null) return;
        if (node.isLeaf) {
            System.out.println("Leaf: " + node.val);
        } else {
            System.out.println("Internal Node");
            System.out.print("Top Left: ");
            printQuadTree(node.topLeft);
            System.out.print("Top Right: ");
            printQuadTree(node.topRight);
            System.out.print("Bottom Left: ");
            printQuadTree(node.bottomLeft);
            System.out.print("Bottom Right: ");
            printQuadTree(node.bottomRight);
        }
    }

    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);
    }

    private Node buildTree(int[][] grid, int row, int col, int size) {
        if (size == 1) {
            return new Node(grid[row][col] == 1, true);
        }

        int newSize = size / 2;
        Node topLeft = buildTree(grid, row, col, newSize);
        Node topRight = buildTree(grid, row, col + newSize, newSize);
        Node bottomLeft = buildTree(grid, row + newSize, col, newSize);
        Node bottomRight = buildTree(grid, row + newSize, col + newSize, newSize);

        // If all four children are leaves and have the same value, merge them into one leaf
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
