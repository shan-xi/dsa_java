package topic.divide_and_conquer._148_Sort_List;

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


public class Solution {

    // Main function for testing
    public static void main(String[] args) {
        Solution sorter = new Solution();

        // Test case 1
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        ListNode sorted1 = sorter.sortList(head1);
        System.out.print("Sorted List 1: ");
        printList(sorted1); // Expected output: 1 -> 2 -> 3 -> 4

        // Test case 2
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);
        ListNode sorted2 = sorter.sortList(head2);
        System.out.print("Sorted List 2: ");
        printList(sorted2); // Expected output: -1 -> 0 -> 3 -> 4 -> 5
    }

    // Helper function to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Function to sort the linked list
    public ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMiddle(head);  // Get the middle node
        ListNode rightHalf = mid.next;   // Start of the second half
        mid.next = null;                 // Break the list into two parts

        // Step 2: Sort each half recursively
        ListNode leftSorted = sortList(head);     // Sort the left half
        ListNode rightSorted = sortList(rightHalf);  // Sort the right half

        // Step 3: Merge the two sorted halves
        return merge(leftSorted, rightSorted);
    }

    // Function to merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify merging
        ListNode current = dummy;

        // Merge nodes from both lists in sorted order
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append remaining nodes, if any
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    // Helper function to find the middle node of the linked list
    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        // Fast pointer moves 2 steps, slow pointer moves 1 step
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow is at the middle node
    }
}
