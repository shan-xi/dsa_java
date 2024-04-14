package _19_Remove_Nth_Node_From_End_of_List;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class PrintResult {
    public static List<Integer> travelAllNodes(ListNode root) {
        var r = new ArrayList<Integer>();
        if (root == null) return r;
        r.add(root.val);
        do {
            root = root.next;
            if (root != null) {
                r.add(root.val);
            }
        } while (root != null && root.next != null);
        return r;
    }
}

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        var root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        var res = s.removeNthFromEnd(root, 2); // [1,2,3,5]
        System.out.println(PrintResult.travelAllNodes(res));

        root = new ListNode(1);
        res = s.removeNthFromEnd(root, 1); // []
        System.out.println(PrintResult.travelAllNodes(res));

        root = new ListNode(1, new ListNode(2));
        res = s.removeNthFromEnd(root, 1); // [1]
        System.out.println(PrintResult.travelAllNodes(res));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        var fast = dummy;
        var slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
