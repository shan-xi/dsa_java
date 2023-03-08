package linked_list_cycle_II;

public class Solution {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null) {

            first = first.next;
            second = second.next.next;

            if (first == second) {
                break;
            }
        }

        if (first == second) {
            first = head;
            while (first != null && second != null) {
                if (first == second) {
                    return first;
                }
                first = first.next;
                second = second.next;
            }
        }

        return null;
    }
}
