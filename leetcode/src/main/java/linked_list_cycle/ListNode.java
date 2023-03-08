package linked_list_cycle;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode node) {
        this.val = x;
        this.next = node;
    }
}
