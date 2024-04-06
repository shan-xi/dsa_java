package hackerrank.algorithms.almostsorted;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 */
class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        int n = arr.size();
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        int count = 0;
        int firstOutOfOrder = -1;
        int lastOutOfOrder = -1;
        for (int i = 0; i < n; i++) {
            if (!arr.get(i).equals(sorted.get(i))) {
                count++;
                if (firstOutOfOrder == -1) {
                    firstOutOfOrder = i;
                }
                lastOutOfOrder = i;
            }
        }

        if (count == 0) {
            System.out.println("yes");
            return;
        }

        if (count == 2) {
            System.out.println("yes");
            System.out.println("swap " + (firstOutOfOrder + 1) + " " + (lastOutOfOrder + 1));
            return;
        }

        List<Integer> reverseSubList = arr.subList(firstOutOfOrder, lastOutOfOrder + 1);
        Collections.reverse(reverseSubList);
        boolean isReversible = reverseSubList.equals(sorted.subList(firstOutOfOrder, lastOutOfOrder + 1));

        if (isReversible) {
            System.out.println("yes");
            System.out.println("reverse " + (firstOutOfOrder + 1) + " " + (lastOutOfOrder + 1));
            return;
        }

        System.out.println("no");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Result.almostSorted(Arrays.asList(4, 2));
        System.out.println();
        Result.almostSorted(Arrays.asList(3, 1, 2));
        System.out.println();
        Result.almostSorted(Arrays.asList(1, 5, 4, 3, 2, 6));
        System.out.println();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        Result.almostSorted(arr);
//
//        bufferedReader.close();
    }
}
