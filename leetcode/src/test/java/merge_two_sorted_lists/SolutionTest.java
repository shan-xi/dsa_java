package merge_two_sorted_lists;

import common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode list1 = n1;
        n1.next = n2;
        n2.next = n3;
        ListNode list2 = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode a = s.mergeTwoLists(list1, list2);
        n1.next = n4;
        n4.next = n2;
        n2.next = n5;
        n5.next = n3;
        n3.next = n6;
        ListNode e = n1;
        while (e != null && a != null) {
            System.out.println(e.val);
            Assertions.assertEquals(e.val, a.val);
            e = e.next;
            a = a.next;
        }
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode a = s.mergeTwoLists(list1, list2);
        ListNode e = null;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode n1 = new ListNode(0);
        list2 = n1;
        ListNode a = s.mergeTwoLists(list1, list2);
        ListNode e = n1;
        while (e != null && a != null) {
            Assertions.assertEquals(e.val, a.val);
            e = e.next;
            a = a.next;
        }
    }
}
