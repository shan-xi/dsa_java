package _215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(s.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}