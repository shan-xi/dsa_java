package topic.sliding_window._return_the_mean_of_the_last_K_elements_in_the_stream;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    double sum;
    Queue<Integer> queue;
    int windowSize;

    MovingAverage(int windowSize) {
        this.windowSize = windowSize;
        queue = new LinkedList<>();
        sum = 0;
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(5);

        int[] stream = {50, 60, 70, 50, 100, 120, 80, 140};
        /**
         * 50.0
         * 55.0
         * 60.0
         * 57.5
         * 66.0
         * 80.0
         * 84.0
         * 98.0
         */
        for (int num : stream) {
            System.out.println(movingAverage.next(num));
        }
    }

    public double next(int val) {
        if (windowSize == queue.size()) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
