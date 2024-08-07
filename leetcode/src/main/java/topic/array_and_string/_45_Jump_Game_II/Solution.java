package topic.array_and_string._45_Jump_Game_II;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums1 = {2, 3, 1, 1, 4};
//        System.out.println(solution.jump(nums1)); // Output: 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums2)); // Output: 2
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
