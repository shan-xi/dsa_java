package TSMC.solution3;

import java.util.Arrays;
import java.util.List;

class Result {
    public static int getMinimumOperations(
            int treeNodes,
            List<Integer> treeFrom,
            List<Integer> treeTo,
            List<Integer> initial,
            List<Integer> expected) {

        return 0;
    }
}

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(Result.getMinimumOperations(
                4,
                Arrays.asList(0, 0, 1),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 1),
                Arrays.asList(0, 1)
        )); // 2

        
    }
}
