package hackerrank.algorithms.greedy_florist;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int miniCost = 0;
        int mp = 1;
        int n = c.length;
        for (int i = n - 1; i >= 0; i -= k) {
            for (int j = 0; j < k && i - j >= 0; j++) {
                miniCost += c[i - j] * mp;
            }
            mp++;
        }
        return miniCost;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getMinimumCost(3, new int[]{1, 2, 3, 4}));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nk = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nk[0]);
//
//        int k = Integer.parseInt(nk[1]);
//
//        int[] c = new int[n];
//
//        String[] cItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int cItem = Integer.parseInt(cItems[i]);
//            c[i] = cItem;
//        }
//
//        int minimumCost = getMinimumCost(k, c);
//
//        bufferedWriter.write(String.valueOf(minimumCost));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
