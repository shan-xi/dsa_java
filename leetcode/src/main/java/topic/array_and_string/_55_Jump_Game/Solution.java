package topic.array_and_string._55_Jump_Game;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums1)); // Output: true
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums2)); // Output: false
        int[] nums3 = {2, 0};
        System.out.println(solution.canJump(nums3));
        int[] nums4 = {0};
        System.out.println(solution.canJump(nums4));
        int[] nums5 = {1};
        System.out.println(solution.canJump(nums5));
        int[] nums6 = {0, 1};
        System.out.println(solution.canJump(nums6));
    }

    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
