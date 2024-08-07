package topic.array_and_string._169_Majority_Element;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3, 2, 3};
        System.out.println(solution.majorityElement(nums1)); // Output: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(solution.majorityElement(nums2)); // Output: 2
    }

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        // Phase 1: Find a candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Phase 2: Verify the candidate (Optional but good practice)
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        // If no majority element is found (though the problem guarantees there is one)
        return -1;
    }
}
