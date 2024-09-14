package topic.backtrack._77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Main function for testing
    public static void main(String[] args) {
        Solution combinations = new Solution();
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combinations.combine(n, k);

        // Print the results
        System.out.println("Combinations of 4 choose 2:");
        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }

    // Main function that returns all combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start, ArrayList<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
