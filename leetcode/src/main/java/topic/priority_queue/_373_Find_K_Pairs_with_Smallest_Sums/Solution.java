package topic.priority_queue._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0] + pair[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] currentPair = minHeap.poll();
            result.add(Arrays.asList(currentPair[0], currentPair[1]));
            k--;

            if (currentPair[2] + 1 < nums2.length) {
                int nums1CurrentValue = currentPair[0];
                int nums2Index = currentPair[2] + 1;
                int nums2Value = nums2[nums2Index];
                minHeap.offer(new int[]{nums1CurrentValue, nums2Value, nums2Index});
            }
        }

        return result;
    }
}
