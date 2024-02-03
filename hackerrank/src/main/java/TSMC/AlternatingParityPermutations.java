package TSMC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 為需要生成一系列數字，這些數字具有交替的奇偶性，即相鄰的兩個數字中，一個是奇數，另一個是偶數。考交替奇偶排列。function需要返回一個二維整數數組，參數是一個整數 n。
 * 返回的是前 n 個正整數的所有交替奇偶排列，這些排列需要按字典順序排序，每個排列是一個 n 元素的數組
 */
public class AlternatingParityPermutations {

    // Function to check if a permutation has alternating parity (odd and even alternately).
    private static boolean isAlternatingParity(int[] permutation) {
        for (int i = 0; i < permutation.length - 1; i++) {
            if ((permutation[i] + permutation[i + 1]) % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to generate all permutations of the first n positive integers with alternating parity.
    private static List<int[]> alternatingParityPermutations(int n) {
        List<int[]> result = new ArrayList<>();

        // Using Collections.singletonList to wrap each integer into a list.
        List<List<Integer>> permutations = Collections.singletonList(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            List<List<Integer>> newPermutations = new ArrayList<>();

            for (List<Integer> permutation : permutations) {
                for (int j = 0; j <= permutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(permutation);
                    newPermutation.add(j, i);
                    newPermutations.add(newPermutation);
                }
            }

            permutations = newPermutations;
        }

        // Filtering and sorting permutations with alternating parity.
        for (List<Integer> perm : permutations) {
            int[] arrayPerm = perm.stream().mapToInt(Integer::intValue).toArray();
            if (isAlternatingParity(arrayPerm)) {
                result.add(arrayPerm);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 4; // Set the desired value for n
        List<int[]> result = alternatingParityPermutations(n);

        // Print the generated permutations
        for (int[] perm : result) {
            for (int num : perm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
