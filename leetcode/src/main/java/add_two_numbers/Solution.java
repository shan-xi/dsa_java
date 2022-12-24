package add_two_numbers;

import util.ListNode;
import util.Utils;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0, null);
        ListNode currNode = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.getVal() : 0;
            int v2 = l2 != null ? l2.getVal() : 0;

            int sumVal = v1 + v2 + carry;
            carry = sumVal / 10;
            ListNode newNode = new ListNode(sumVal % 10, null);
            currNode.setNext(newNode);
            currNode = newNode;

            l1 = l1 != null ? l1.getNext() : null;
            l2 = l2 != null ? l2.getNext() : null;
        }
        return dummyNode.getNext();
    }

    public static void main(String[] args) {
        ListNode l1 = Utils.buildSingleLinkedListFromArray(new int[]{3, 4, 2});
        ListNode l2 = Utils.buildSingleLinkedListFromArray(new int[]{4, 6, 5});
        String r = Utils.getListStringResult(addTwoNumbers(l1, l2));
        System.out.println(r);
    }
}