package topic.priority_queue._1825_Finding_MK_Average;

import java.util.*;

class MKAverage {
    private final int m;
    private final int k;
    private final Deque<Integer> deque;
    private final PriorityQueue<Integer> small;
    private final PriorityQueue<Integer> large;
    private final TreeMap<Integer, Integer> mid;
    private long midSum;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.deque = new LinkedList<>();
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
        this.mid = new TreeMap<>();
        this.midSum = 0;
    }

    public static void main(String[] args) {
        MKAverage mk = new MKAverage(3, 1);

        mk.addElement(3);
        mk.addElement(1);
        System.out.println(mk.calculateMKAverage()); // Expected output: -1

        mk.addElement(10);
        System.out.println(mk.calculateMKAverage()); // Expected output: 3

        mk.addElement(5);
        System.out.println(mk.calculateMKAverage()); // Expected output: 5

        mk.addElement(5);
        System.out.println(mk.calculateMKAverage()); // Expected output: 5
    }

    public void addElement(int num) {
        if (deque.size() == m) {
            int oldest = deque.pollFirst();
            removeElement(oldest);
        }

        deque.addLast(num);
        addElementToDataStructures(num);
    }

    private void addElementToDataStructures(int num) {
        if (small.size() < k || num <= small.peek()) {
            small.add(num);
            if (small.size() > k) {
                int moved = small.poll();
                mid.put(moved, mid.getOrDefault(moved, 0) + 1);
                midSum += moved;
            }
        } else if (large.size() < k || num >= large.peek()) {
            large.add(num);
            if (large.size() > k) {
                int moved = large.poll();
                mid.put(moved, mid.getOrDefault(moved, 0) + 1);
                midSum += moved;
            }
        } else {
            mid.put(num, mid.getOrDefault(num, 0) + 1);
            midSum += num;
        }

        balance();
    }

    private void removeElement(int num) {
        if (small.contains(num)) {
            small.remove(num);
        } else if (large.contains(num)) {
            large.remove(num);
        } else {
            mid.put(num, mid.get(num) - 1);
            if (mid.get(num) == 0) {
                mid.remove(num);
            }
            midSum -= num;
        }

        balance();
    }

    private void balance() {
        while (small.size() < k && !mid.isEmpty()) {
            int moved = mid.firstKey();
            midSum -= moved;
            if (mid.get(moved) == 1) {
                mid.remove(moved);
            } else {
                mid.put(moved, mid.get(moved) - 1);
            }
            small.add(moved);
        }

        while (large.size() < k && !mid.isEmpty()) {
            int moved = mid.lastKey();
            midSum -= moved;
            if (mid.get(moved) == 1) {
                mid.remove(moved);
            } else {
                mid.put(moved, mid.get(moved) - 1);
            }
            large.add(moved);
        }

        while (small.size() > k) {
            int moved = small.poll();
            mid.put(moved, mid.getOrDefault(moved, 0) + 1);
            midSum += moved;
        }

        while (large.size() > k) {
            int moved = large.poll();
            mid.put(moved, mid.getOrDefault(moved, 0) + 1);
            midSum += moved;
        }
    }

    public int calculateMKAverage() {
        if (deque.size() < m) {
            return -1;
        }
        return (int) (midSum / (m - 2 * k));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
