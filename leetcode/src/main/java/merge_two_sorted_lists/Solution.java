package merge_two_sorted_lists;

import common.ListNode;

// 21.Merge Two Sorted Lists
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curNode = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curNode.next = list1;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }
        if (list1 != null) {
            curNode.next = list1;
        }
        if (list2 != null) {
            curNode.next = list2;
        }

        return dummyNode.next;
    }
}
