package linked_list_cycle_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        ListNode n4 = new ListNode(-4);
        ListNode n3 = new ListNode(0, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(3, n2);
        n4.next = n2;
        ListNode actual = s.detectCycle(n1);
        Assertions.assertEquals(n2, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(3, n2);
        n2.next = n1;
        ListNode actual = s.detectCycle(n1);
        Assertions.assertEquals(n1, actual);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode actual = s.detectCycle(n1);
        Assertions.assertEquals(null, actual);
    }

    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        ListNode n1 = null;
        ListNode actual = s.detectCycle(n1);
        Assertions.assertEquals(null, actual);
    }
}
