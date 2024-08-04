package topic.monotonic_queue._2762_Continuous_Subarrays;

import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {5, 4, 2, 4};
        int[] nums2 = {1, 2, 3};

        System.out.println(solution.continuousSubarrays(nums1)); // Output: 8
        System.out.println(solution.continuousSubarrays(nums2)); // Output: 6
    }

    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int i = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}
