package middle_of_the_linked_list;

//https://leetcode.com/problems/middle-of-the-linked-list/
//876. Middle of the Linked List
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }
}
