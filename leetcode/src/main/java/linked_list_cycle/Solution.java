package linked_list_cycle;

//https://leetcode.com/problems/linked-list-cycle/
//141. Linked List Cycle
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }
}
