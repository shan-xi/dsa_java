package topic.priority_queue._1985_Find_the_Kth_Largest_Integer_in_the_Array;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] nums = {"3", "6", "7", "10"};
        int k = 4;
        System.out.println(solution.kthLargestNumber(nums, k)); // Output: "3"

        nums = new String[]{"2", "21", "12", "1"};
        k = 3;
        System.out.println(solution.kthLargestNumber(nums, k)); // Output: "2"

        nums = new String[]{"0", "0"};
        k = 2;
        System.out.println(solution.kthLargestNumber(nums, k)); // Output: "0"
    }

    public String kthLargestNumber(String[] nums, int k) {
        // Min-heap to store the k largest numbers
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return Integer.compare(a.length(), b.length());
            }
        });

        // Iterate through all numbers
        for (String num : nums) {
            minHeap.offer(num);
            // Maintain the size of the heap to be k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the k-th largest number
        return minHeap.peek();
    }
}
