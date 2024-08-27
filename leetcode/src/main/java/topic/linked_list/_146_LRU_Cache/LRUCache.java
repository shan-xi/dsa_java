package topic.linked_list._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

//        System.out.println(cache.get(2)); // Should return -1 (not found)
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1)); // Should return 1
//        cache.put(3, 3); // Evicts key 2
//        System.out.println(cache.get(2)); // Should return -1 (not found)
//        cache.put(4, 4); // Evicts key 1
//        System.out.println(cache.get(1)); // Should return -1 (not found)
//        System.out.println(cache.get(3)); // Should return 3
//        System.out.println(cache.get(4)); // Should return 4
//
//        // Additional test cases to ensure correctness
//        cache.put(2, 2);
//        System.out.println(cache.get(4)); // Should return 4
//        cache.put(5, 5); // Evicts key 3
//        System.out.println(cache.get(3)); // Should return -1 (not found)
//        System.out.println(cache.get(5)); // Should return 5
//        System.out.println(cache.get(2)); // Should return 2
        // Test cases with both positive and negative keys and values
        cache.put(-1, -1);
        System.out.println(cache.get(-1)); // Should return -1

        cache.put(-2, -2);
        System.out.println(cache.get(-2)); // Should return -2

        cache.put(3, 3); // Evicts key -1
        System.out.println(cache.get(-1)); // Should return -1 (evicted)

        cache.put(-4, -4); // Evicts key -2
        System.out.println(cache.get(-2)); // Should return -1 (evicted)
        System.out.println(cache.get(3));  // Should return 3
        System.out.println(cache.get(-4)); // Should return -4

        // Further edge cases
        cache.put(-5, 5); // Evicts key 3
        System.out.println(cache.get(3));  // Should return -1 (evicted)
        System.out.println(cache.get(-5)); // Should return 5
        System.out.println(cache.get(-4)); // Should return -4
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
        }
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
}
