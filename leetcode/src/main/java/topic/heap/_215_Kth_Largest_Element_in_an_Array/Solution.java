package topic.heap._215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal array, k = 2 (Second largest element)
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Test 1 - Kth largest element: " + solution.findKthLargest(nums1, k1));  // Output: 5

        // Test case 2: Normal array, k = 1 (Largest element)
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 1;
        System.out.println("Test 2 - Kth largest element: " + solution.findKthLargest(nums2, k2));  // Output: 6

        // Test case 3: Single element array
        int[] nums3 = {1};
        int k3 = 1;
        System.out.println("Test 3 - Kth largest element: " + solution.findKthLargest(nums3, k3));  // Output: 1

        // Test case 4: K equals array length (Smallest element)
        int[] nums4 = {7, 10, 4, 3, 20, 15};
        int k4 = 6;
        System.out.println("Test 4 - Kth largest element: " + solution.findKthLargest(nums4, k4));  // Output: 3
    }

    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store only the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                // If heap size is less than k, add element
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                // If the current number is larger than the smallest in the heap
                minHeap.poll();  // Remove the smallest
                minHeap.offer(num);  // Add the current larger element
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}
