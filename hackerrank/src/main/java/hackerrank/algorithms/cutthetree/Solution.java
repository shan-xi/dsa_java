package hackerrank.algorithms.cutthetree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    static int minDiff;

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        int totalSum = data.stream().mapToInt(Integer::intValue).sum();
        int n = data.size();
        minDiff = Integer.MAX_VALUE;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        dfs(1, -1, data, adjList, totalSum);
        return minDiff;
    }

    private static int dfs(int u, int parent, List<Integer> data, List<List<Integer>> adjList, int totalSum) {
        int subtreeSum = data.get(u - 1);

        for (int v : adjList.get(u)) {
            if (v != parent) {
                subtreeSum += dfs(v, u, data, adjList, totalSum);
            }
        }

        int otherSubtreeSum = totalSum - subtreeSum;
        minDiff = Math.min(minDiff, Math.abs(subtreeSum - otherSubtreeSum));

        return subtreeSum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
