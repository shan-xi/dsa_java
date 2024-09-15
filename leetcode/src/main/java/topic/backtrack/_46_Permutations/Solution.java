package topic.backtrack._46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Main function for testing
    public static void main(String[] args) {
        Solution permutations = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);

        // Print all permutations
        System.out.println("Permutations of [1, 2, 3]:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    // Main function to return all permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }

    private void backtrack(int[] nums, ArrayList<Integer> current, List<List<Integer>> result, int start) {
        System.out.println(current);
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, current, result, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
