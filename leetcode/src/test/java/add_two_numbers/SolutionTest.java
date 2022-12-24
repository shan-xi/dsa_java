package add_two_numbers;

import org.junit.jupiter.api.Test;
import util.ListNode;
import util.Utils;

import static add_two_numbers.Solution.addTwoNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testCase1Success() {
        ListNode l1 = Utils.buildSingleLinkedListFromArray(new int[]{3, 4, 2});
        ListNode l2 = Utils.buildSingleLinkedListFromArray(new int[]{4, 6, 5});
        String r = Utils.getListStringResult(addTwoNumbers(l1, l2));
        assertEquals(r, "708");
    }

    @Test
    void testCase2Success() {
        ListNode l1 = Utils.buildSingleLinkedListFromArray(new int[]{0});
        ListNode l2 = Utils.buildSingleLinkedListFromArray(new int[]{0});
        String r = Utils.getListStringResult(addTwoNumbers(l1, l2));
        assertEquals(r, "0");
    }

    @Test
    void testCase3Success() {
        ListNode l1 = Utils.buildSingleLinkedListFromArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = Utils.buildSingleLinkedListFromArray(new int[]{9, 9, 9, 9});
        String r = Utils.getListStringResult(addTwoNumbers(l1, l2));
        assertEquals(r, "89990001");
    }
}
