package topic.sliding_window._return_the_mean_of_the_last_K_elements_in_the_stream;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
public class MovingAverageExcludeLargestX {
    int size;
    Queue<Integer> window;
    int x;

    public MovingAverageExcludeLargestX(int k, int x) {
        this.size = k;
        this.window = new LinkedList<>();
        this.x = x;
    }

    public static void main(String[] args) {
        MovingAverageExcludeLargestX movingAverage = new MovingAverageExcludeLargestX(5, 2);

        int[] stream = {50, 60, 70, 50, 100, 120, 80, 140};
        for (int num : stream) {
            System.out.println(movingAverage.next(num));
        }
    }

    public double next(int val) {
        if (size == window.size()) {
            window.poll();
        }

        window.offer(val);

        if (window.size() > x) {
            double sum = 0.0;
            PriorityQueue<Integer> minHeaps = new PriorityQueue<>();
            for (int i : window) {
                minHeaps.offer(i);
            }
            int heapSize = minHeaps.size();
            int count = 0;
            for (int i = 0; i < heapSize - x; i++) {
                sum += minHeaps.poll();
                count++;
            }
            return sum / count;
        } else {
            return -1;
        }
    }
}
