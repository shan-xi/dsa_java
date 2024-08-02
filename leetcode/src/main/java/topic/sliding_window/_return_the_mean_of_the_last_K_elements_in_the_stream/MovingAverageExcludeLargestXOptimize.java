package topic.sliding_window._return_the_mean_of_the_last_K_elements_in_the_stream;

import java.util.*;

public class MovingAverageExcludeLargestXOptimize {
    private final int m;
    private final int k;
    private final Queue<Integer> window;
    private final PriorityQueue<Integer> minHeap;  // Smallest k elements
    private final PriorityQueue<Integer> maxHeap;  // Largest k elements
    private final TreeMap<Integer, Integer> midMap; // Middle elements
    private long midSum;

    public MovingAverageExcludeLargestXOptimize(int m, int k) {
        this.m = m;
        this.k = k;
        this.window = new LinkedList<>();
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.midMap = new TreeMap<>();
        this.midSum = 0;
    }

    public static void main(String[] args) {
        MovingAverageExcludeLargestX movingAverage = new MovingAverageExcludeLargestX(5, 2);

        /**
         * 50 -> -1
         * 60 -> -1
         * 70 -> 50
         * 50 -> 50
         * 100 -> (50+60+50)/3 53.33
         * 120 -> (50+60+70)/3 60
         * 80 -> (50+70+80)/3 66.6
         * 140 -> (50+100+80)/3 76.6
         */
        int[] stream = {50, 60, 70, 50, 100, 120, 80, 140};
        for (int num : stream) {
            System.out.println(movingAverage.next(num));
        }
    }

    public double next(int val) {
        if (window.size() == m) {
            int oldest = window.poll();
            removeElement(oldest);
        }

        window.offer(val);
        addElement(val);

        if (window.size() < m) {
            return -1;
        } else {
            return midSum / (double) (m - 2 * k);
        }
    }

    private void addElement(int num) {
        if (minHeap.size() < k || num <= minHeap.peek()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                int moved = minHeap.poll();
                midMap.put(moved, midMap.getOrDefault(moved, 0) + 1);
                midSum += moved;
            }
        } else if (maxHeap.size() < k || num >= maxHeap.peek()) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                int moved = maxHeap.poll();
                midMap.put(moved, midMap.getOrDefault(moved, 0) + 1);
                midSum += moved;
            }
        } else {
            midMap.put(num, midMap.getOrDefault(num, 0) + 1);
            midSum += num;
        }

        balance();
    }

    private void removeElement(int num) {
        if (!minHeap.isEmpty() && num <= minHeap.peek()) {
            minHeap.remove(num);
        } else if (!maxHeap.isEmpty() && num >= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            midMap.put(num, midMap.get(num) - 1);
            if (midMap.get(num) == 0) {
                midMap.remove(num);
            }
            midSum -= num;
        }

        balance();
    }

    private void balance() {
        while (minHeap.size() > k) {
            int moved = minHeap.poll();
            midMap.put(moved, midMap.getOrDefault(moved, 0) + 1);
            midSum += moved;
        }

        while (maxHeap.size() > k) {
            int moved = maxHeap.poll();
            midMap.put(moved, midMap.getOrDefault(moved, 0) + 1);
            midSum += moved;
        }

        while (minHeap.size() < k && !midMap.isEmpty()) {
            int moved = midMap.firstKey();
            midSum -= moved;
            if (midMap.get(moved) == 1) {
                midMap.remove(moved);
            } else {
                midMap.put(moved, midMap.get(moved) - 1);
            }
            minHeap.offer(moved);
        }

        while (maxHeap.size() < k && !midMap.isEmpty()) {
            int moved = midMap.lastKey();
            midSum -= moved;
            if (midMap.get(moved) == 1) {
                midMap.remove(moved);
            } else {
                midMap.put(moved, midMap.get(moved) - 1);
            }
            maxHeap.offer(moved);
        }
    }
}
