package topic.linked_list._707_Design_Linked_List;

public class MyLinkedList {
    private Node head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        // Add at head
        linkedList.addAtHead(1);
        System.out.println("After addAtHead(1): " + linkedListToString(linkedList)); // Expected: 1

        // Add at tail
        linkedList.addAtTail(3);
        System.out.println("After addAtTail(3): " + linkedListToString(linkedList)); // Expected: 1 -> 3

        // Add at index
        linkedList.addAtIndex(1, 2);
        System.out.println("After addAtIndex(1, 2): " + linkedListToString(linkedList)); // Expected: 1 -> 2 -> 3

        // Get
        int value = linkedList.get(1);
        System.out.println("Get(1): " + value); // Expected: 2

        // Delete at index
        linkedList.deleteAtIndex(1);
        System.out.println("After deleteAtIndex(1): " + linkedListToString(linkedList)); // Expected: 1 -> 3

        // Get after deletion
        value = linkedList.get(1);
        System.out.println("Get(1) after deletion: " + value); // Expected: 3
    }

    private static String linkedListToString(MyLinkedList linkedList) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (true) {
            int value = linkedList.get(index);
            if (value == -1) {
                break;
            }
            if (index > 0) {
                sb.append(" -> ");
            }
            sb.append(value);
            index++;
        }
        return sb.toString();
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
