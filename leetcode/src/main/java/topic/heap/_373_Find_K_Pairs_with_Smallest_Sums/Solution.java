package topic.heap._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: k = 3, find the 3 pairs with smallest sums
        int[] nums1_1 = {1, 7, 11};
        int[] nums2_1 = {2, 4, 6};
        int k1 = 3;
        List<List<Integer>> result1 = solution.kSmallestPairs(nums1_1, nums2_1, k1);
        System.out.println("Test 1: " + result1);  // Expected output: [[1, 2], [1, 4], [1, 6]]

        // Test case 2: k = 2, find the 2 pairs with smallest sums
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3};
        int k2 = 2;
        List<List<Integer>> result2 = solution.kSmallestPairs(nums1_2, nums2_2, k2);
        System.out.println("Test 2: " + result2);  // Expected output: [[1, 3], [2, 3]]

        // Test case 3: k = 5, with larger arrays
        int[] nums1_3 = {1, 1, 2};
        int[] nums2_3 = {1, 2, 3};
        int k3 = 5;
        List<List<Integer>> result3 = solution.kSmallestPairs(nums1_3, nums2_3, k3);
        System.out.println("Test 3: " + result3);  // Expected output: [[1, 1], [1, 1], [2, 1], [1, 2], [1, 2]]
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap storing [sum, i, j], where sum = nums1[i] + nums2[j]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initialize the heap with the smallest element from nums1 and all elements from nums2
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Extract the k smallest pairs
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1];
            int j = current[2];

            // Add the current pair to the result
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            result.add(pair);

            // If there is a next element in nums2, push it into the heap
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;
    }
}

