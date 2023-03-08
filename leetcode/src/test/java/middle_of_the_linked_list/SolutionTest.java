package middle_of_the_linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode actual = s.middleNode(root);
        ListNode expect = new ListNode(3, new ListNode(4, new ListNode(5)));
        while (actual != null) {
            Assertions.assertEquals(expect.val, actual.val);
            actual = actual.next;
            expect = expect.next;
        }
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode actual = s.middleNode(root);
        ListNode expect = new ListNode(4, new ListNode(5, new ListNode(6)));
        while (actual != null) {
            Assertions.assertEquals(expect.val, actual.val);
            actual = actual.next;
            expect = expect.next;
        }
    }
}
