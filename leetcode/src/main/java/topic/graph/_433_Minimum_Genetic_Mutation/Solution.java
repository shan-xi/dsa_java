package topic.graph._433_Minimum_Genetic_Mutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Test function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Expected output is 1
        String start1 = "AACCGGTT";
        String end1 = "AACCGGTA";
        String[] bank1 = {"AACCGGTA"};
        System.out.println("Minimum mutations: " + solution.minMutation(start1, end1, bank1));

        // Test case 2: Expected output is 2
        String start2 = "AACCGGTT";
        String end2 = "AAACGGTA";
        String[] bank2 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println("Minimum mutations: " + solution.minMutation(start2, end2, bank2));

        // Test case 3: Expected output is 3
        String start3 = "AAAAACCC";
        String end3 = "AACCCCCC";
        String[] bank3 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println("Minimum mutations: " + solution.minMutation(start3, end3, bank3));

        // Test case 4: Expected output is -1 (not possible to reach the end)
        String start4 = "AAAAACCC";
        String end4 = "AACCCCCC";
        String[] bank4 = {"AAAACCCC"};
        System.out.println("Minimum mutations: " + solution.minMutation(start4, end4, bank4));
    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));  // Convert bank to a set for fast lookup

        if (!bankSet.contains(end)) {
            return -1;  // If the end gene is not in the bank, return -1
        }

        Set<String> beginSet = new HashSet<>();  // Start point
        Set<String> endSet = new HashSet<>();    // End point
        Set<String> visited = new HashSet<>();   // Visited genes
        char[] genes = new char[]{'A', 'C', 'G', 'T'};  // Allowed mutations

        beginSet.add(start);
        endSet.add(end);
        visited.add(start);
        visited.add(end);
        int mutations = 0;  // Keep track of the number of mutations

        // Bi-directional BFS loop
        while (!beginSet.isEmpty()) {
            // Always expand the smaller set to minimize search space
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            // Perform BFS from the current level
            for (String gene : beginSet) {
                char[] geneArray = gene.toCharArray();

                // Try all possible mutations
                for (int i = 0; i < geneArray.length; i++) {
                    char oldChar = geneArray[i];

                    for (char c : genes) {
                        geneArray[i] = c;
                        String mutatedGene = new String(geneArray);

                        if (endSet.contains(mutatedGene)) {
                            return mutations + 1;  // If the mutation meets the other BFS, return result
                        }

                        if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                            nextLevel.add(mutatedGene);
                            visited.add(mutatedGene);
                        }
                    }
                    geneArray[i] = oldChar;  // Restore the original character
                }
            }

            beginSet = nextLevel;  // Move to the next level
            mutations++;  // Increment mutation count after each level
        }

        return -1;  // If no valid mutation path is found
    }
}
