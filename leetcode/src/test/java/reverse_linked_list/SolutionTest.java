package reverse_linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode actual = s.reverseList(n1);

        n5.next = n4;
        n4.next = n3;
        n3.next = n2;
        n2.next = n1;
        n1.next = null;

        ListNode expect = n5;
        while (actual != null) {
            Assertions.assertEquals(expect, actual);
            expect = expect.next;
            actual = n1.next;
        }
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1, n2);
        ListNode actual = s.reverseList(n1);

        n2.next = n1;
        n1.next = null;

        ListNode expect = n2;
        while (actual != null) {
            Assertions.assertEquals(expect, actual);
            expect = expect.next;
            actual = n1.next;
        }
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();

        ListNode n1 = null;
        ListNode actual = s.reverseList(n1);
        ListNode expect = null;
        Assertions.assertEquals(expect, actual);
    }
}
