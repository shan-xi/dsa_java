package linked_list_cycle;

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
        boolean actual = s.hasCycle(n1);
        boolean expect = true;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        boolean actual = s.hasCycle(new ListNode(1, new ListNode(2)));
        boolean expect = false;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        boolean actual = s.hasCycle(n1);
        boolean expect = true;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        boolean actual = s.hasCycle(n1);
        boolean expect = false;
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void test_case5_success() {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        boolean actual = s.hasCycle(n1);
        boolean expect = false;
        Assertions.assertEquals(expect, actual);
    }
}
