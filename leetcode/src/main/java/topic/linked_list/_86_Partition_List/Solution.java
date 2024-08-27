package topic.linked_list._86_Partition_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    // Main function for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;
        ListNode result = sol.partition(head, x);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0); // Dummy node for the 'before' list
        ListNode before = beforeHead; // Pointer to construct the 'before' list
        ListNode afterHead = new ListNode(0); // Dummy node for the 'after' list
        ListNode after = afterHead; // Pointer to construct the 'after' list

        // Traverse and partition
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Combine the two lists
        after.next = null; // Terminate the 'after' list
        before.next = afterHead.next; // Connect the 'before' list with the 'after' list

        return beforeHead.next; // Return the head of the combined list
    }
}

