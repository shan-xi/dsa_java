package unique_binary_search_trees;

public class Solution {
    public int numTrees(int n) {
        /**
         * n = 1 -> 1
         * n = 2 -> 2
         * n = 3 -> 5 => n[2] + n[1]*n[1] + n[2] = 2 + 1 + 2 = 5
         * n = 4 -> 14 => n[3] + n[1]*n[2] + n[2]*n[1] + n[3] = 5 + 2 + 2 + 5 = 14
         * n = 5 -> 42 => n[4] + n[1]*n[3] + n[2]*n[2] + n[3]*n[1] + n[4] = 14 + 5 + 4 + 5 + 14 = 42
         */

        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp += arr[j] * arr[i - j - 1];
            }
            arr[i] = temp;
        }
        return arr[n];
    }
}
