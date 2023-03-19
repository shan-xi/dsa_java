package remove_duplicates_from_sorted_list;

import common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        Solution s = new Solution();
        ListNode a = s.deleteDuplicates(n1);
        List<Integer> al = new ArrayList<>();
        while (a != null) {
            al.add(a.val);
            a = a.next;
        }
        String actual = al.toString();
        String e = "[1, 2]";
        Assertions.assertEquals(e, actual);
    }

    @Test
    public void test_case2_success() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Solution s = new Solution();
        ListNode a = s.deleteDuplicates(n1);
        List<Integer> al = new ArrayList<>();
        while (a != null) {
            al.add(a.val);
            a = a.next;
        }
        String actual = al.toString();
        String e = "[1, 2, 3]";
        Assertions.assertEquals(e, actual);
    }

    @Test
    public void test_case3_success() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        Solution s = new Solution();
        ListNode a = s.deleteDuplicates(n1);
        List<Integer> al = new ArrayList<>();
        while (a != null) {
            al.add(a.val);
            a = a.next;
        }
        String actual = al.toString();
        String e = "[1]";
        Assertions.assertEquals(e, actual);
    }
}
