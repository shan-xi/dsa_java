package hackerrank.datastructure.downtozerotwo;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Result {

    /*
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int downToZero(int n) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(n);
        visited.add(n);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == 0) {
                    return steps;
                }
                for (int j = 2; j <= Math.sqrt(current); j++) {
                    if (current % j == 0) {
                        int factor = Math.max(j, current / j);
                        int next = Math.max(factor, current / factor);
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
                if (!visited.contains(current - 1)) {
                    queue.offer(current - 1);
                    visited.add(current - 1);
                }

            }
            steps++;
        }


        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int result = Result.downToZero(4);
        System.out.println(result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                int result = Result.downToZero(n);
//
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
