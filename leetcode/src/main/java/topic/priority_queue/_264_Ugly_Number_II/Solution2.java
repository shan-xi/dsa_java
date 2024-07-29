package topic.priority_queue._264_Ugly_Number_II;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// Priority queue

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int n = 10;  // Example input
        System.out.println(solution.nthUglyNumber(n));  // Output the 10th ugly number
    }

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();

        // Initial ugly number
        minHeap.add(1L);
        seen.add(1L);

        long currentUgly = 1;

        for (int i = 0; i < n; i++) {
            currentUgly = minHeap.poll();

            // Generate new ugly numbers by multiplying by 2, 3, and 5
            long nextUgly2 = currentUgly * 2;
            long nextUgly3 = currentUgly * 3;
            long nextUgly5 = currentUgly * 5;

            // Add new ugly numbers to the heap if they haven't been seen
            if (seen.add(nextUgly2)) {
                minHeap.add(nextUgly2);
            }
            if (seen.add(nextUgly3)) {
                minHeap.add(nextUgly3);
            }
            if (seen.add(nextUgly5)) {
                minHeap.add(nextUgly5);
            }
        }

        return (int) currentUgly;
    }
}
