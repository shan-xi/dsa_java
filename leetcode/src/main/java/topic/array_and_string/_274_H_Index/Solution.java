package topic.array_and_string._274_H_Index;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println(solution.hIndex(citations1)); // Output: 3

        int[] citations2 = {1, 3, 1};
        System.out.println(solution.hIndex(citations2)); // Output: 1
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        // Count the number of papers for each citation count
        for (int citation : citations) {
            if (citation >= n) {
                count[n]++;
            } else {
                count[citation]++;
            }
        }

        // Calculate the h-index
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }
}
