package topic.linked_list._160_Intersection_of_Two_Linked_Lists;

public class Solution {
    public static void main(String[] args) {
        // Create intersecting linked lists
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        // List A: 4 -> 1 -> 8 -> 10
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;

        // List B: 5 -> 6 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        Solution solution = new Solution();
        ListNode result = solution.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection node value: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse through both lists
        while (pointerA != pointerB) {
            // Move to the next node, or switch to the head of the other list if reaching the end
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Either both pointers meet at the intersection node, or both are null (no intersection)
        return pointerA;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
