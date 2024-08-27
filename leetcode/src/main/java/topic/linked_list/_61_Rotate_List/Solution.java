package topic.linked_list._61_Rotate_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    // Main function for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Rotating the list by 2 places
        ListNode result = solution.rotateRight(head, 2);

        // Printing the rotated list
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        // Expected output: 4 -> 5 -> 1 -> 2 -> 3 ->
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Compute the length of the list and connect the tail to the head
        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }
        oldTail.next = head; // Form a circle

        // Step 2: Find the new head and tail
        int newTailPos = length - k % length - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailPos; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Step 3: Break the circle
        newTail.next = null;

        return newHead;
    }
}
