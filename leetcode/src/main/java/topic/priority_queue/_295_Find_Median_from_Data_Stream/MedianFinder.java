package topic.priority_queue._295_Find_Median_from_Data_Stream;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    // Max-heap for the smaller half
    private final PriorityQueue<Integer> left;
    // Min-heap for the larger half
    private final PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        // Test case 1
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5

        // Test case 2
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2
    }

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Balance the heaps
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else if (right.size() > left.size()) {
            return right.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}
