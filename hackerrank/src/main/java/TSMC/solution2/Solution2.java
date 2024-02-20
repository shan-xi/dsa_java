package TSMC.solution2;

import java.util.Arrays;
import java.util.List;

class Result {
    static int counter = 0;

    public static void createBST(List<Integer> keys) {
        Node root = null;
        for (int key : keys) {
            if (root != null) {
                insert(root, key);
            } else {
                root = new Node(key);
            }
            System.out.println(counter);
        }
    }

    private static void insert(Node root, int key) {
        counter++;
        if (key <= root.value) {
            if (root.left == null) {
                root.left = new Node(key);
            } else {
                insert(root.left, key);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(key);
            } else {
                insert(root.right, key);
            }
        }
    }
}

class Node {
    public Node parent;
    public Node left;
    public Node right;
    public int value;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(Node parent, Node left, Node right, int value) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
    }
}

public class Solution2 {
    public static void main(String[] args) {
//        Result.createBST(Arrays.asList(2, 1, 3, 4)); // 0 1 2 4
//        Result.createBST(Arrays.asList(2, 1, 3)); // 0 1 2
        Result.createBST(Arrays.asList(1, 2, 3)); // 0 1 3
    }
}
