package topic.binary_tree._117_Populating_Next_Right_Pointers_in_Each_Node_II;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        Node result = solution.connect(root);

        // Test by printing the next pointers for each level
        Node current = result;
        while (current != null) {
            Node temp = current;
            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
            current = current.left != null ? current.left : current.right;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;

        Node current = root;
        Node dummyHead = new Node(0);
        Node prev = dummyHead;

        while (current != null) {
            if (current.left != null) {
                prev.next = current.left;
                prev = prev.next;
            }
            if (current.right != null) {
                prev.next = current.right;
                prev = prev.next;
            }
            current = current.next;
            if (current == null) {
                current = dummyHead.next;
                dummyHead.next = null;
                prev = dummyHead;
            }
        }

        return root;
    }
}
