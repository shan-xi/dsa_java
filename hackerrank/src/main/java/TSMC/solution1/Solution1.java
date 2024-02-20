package TSMC.solution1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Result {
    public static int getMaximumMex(List<Integer> arr) {
        int n = arr.size();
        Collections.sort(arr);
        boolean[] used = new boolean[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) >= index && !used[index]) {
                used[index] = true;
                index++;
            }
        }
        int count = 0;
        for (boolean b : used) {
            if (b) {
                count++;
            }
        }
        return count;
    }
}

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Result.getMaximumMex(Arrays.asList(3, 2, 3)));
        System.out.println(Result.getMaximumMex(Arrays.asList(1, 2, 2)));
        System.out.println(Result.getMaximumMex(Arrays.asList(0, 0)));
        System.out.println(Result.getMaximumMex(Arrays.asList(1, 2, 2)));
        System.out.println(Result.getMaximumMex(Arrays.asList(2, 0, 0))); // 2
    }
}
