package remove_linked_list_elements;

import common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode a = s.removeElements(n1, 6);

        n1.next = n2;
        n2.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        ListNode e = n1;
        while (a != null) {
            System.out.println(a.val + " " + e.val);
            Assertions.assertEquals(e.val, a.val);
            e = e.next;
            a = a.next;
        }
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        ListNode n1 = null;
        ListNode a = s.removeElements(n1, 1);
        ListNode e = n1;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode a = s.removeElements(n1, 7);
        ListNode e = null;
        Assertions.assertEquals(e, a);
    }
}
