package topic.linked_list._138_Copy_List_with_Random_Pointer;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;

        Node copiedList = solution.copyRandomList(head);

        // Print copied list
        Node curr = copiedList;
        while (curr != null) {
            System.out.print("Node val: " + curr.val + ", ");
            System.out.println("Random points to: " + (curr.random != null ? curr.random.val : "null"));
            curr = curr.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Interleave original and copied nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the interleaved list into original and copied lists
        Node dummy = new Node(0);
        Node copy = dummy;
        curr = head;
        while (curr != null) {
            Node next = curr.next.next;

            // Extract the copy
            copy.next = curr.next;

            // Restore the original list
            curr.next = next;

            curr = next;
            copy = copy.next;
        }

        return dummy.next;
    }
}
