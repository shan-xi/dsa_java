package topic.linked_list._24_Swap_Nodes_in_Pairs;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a linked list 1->2->3->4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Swap pairs
        ListNode result = solution.swapPairs(head);

        // Print the swapped linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Expected output: 2 1 4 3
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            current.next = second;
            current.next.next = first;

            current = current.next.next;
        }

        return dummy.next;
    }
}
