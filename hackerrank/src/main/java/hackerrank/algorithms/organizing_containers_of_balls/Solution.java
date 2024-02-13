package hackerrank.algorithms.organizing_containers_of_balls;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        int n = container.size();
        int[] containerCapacity = new int[n];
        int[] ballCounts = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                containerCapacity[i] += container.get(i).get(j);
                ballCounts[j] += container.get(i).get(j);
            }
        }

        Arrays.sort(containerCapacity);
        Arrays.sort(ballCounts);

        if (Arrays.equals(containerCapacity, ballCounts)) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.organizingContainers(
                        Arrays.asList(
                                Arrays.asList(0, 2, 1),
                                Arrays.asList(1, 1, 1),
                                Arrays.asList(2, 0, 0)
                        )
                )
        );
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<List<Integer>> container = new ArrayList<>();
//
//                IntStream.range(0, n).forEach(i -> {
//                    try {
//                        container.add(
//                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                        .map(Integer::parseInt)
//                                        .collect(toList())
//                        );
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//
//                String result = Result.organizingContainers(container);
//
//                bufferedWriter.write(result);
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
