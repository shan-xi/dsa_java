package hackerrank.algorithms.eventree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // Complete the evenForest function below.
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        Map<Integer, List<Integer>> adjacentList = new HashMap<>();
        for (int i = 0; i < t_edges; i++) {
            adjacentList.computeIfAbsent(t_from.get(i), a -> new ArrayList<>()).add(t_to.get((i)));
            adjacentList.computeIfAbsent(t_to.get(i), a -> new ArrayList<>()).add(t_from.get((i)));
        }
        int[] subTreeNodes = new int[t_nodes + 1];
        dfs(1, -1, adjacentList, subTreeNodes);

        int remove = 0;
        for (int subTreeNode : subTreeNodes) {
            if (subTreeNode != 0 && subTreeNode % 2 == 0) {
                remove++;
            }
        }
        return remove - 1;
    }

    private static void dfs(int current, int parent, Map<Integer, List<Integer>> adjacentList, int[] subTreeNodes) {
        subTreeNodes[current] = 1;
        if (adjacentList.containsKey(current)) {
            for (int neighbor : adjacentList.get(current)) {
                if (neighbor != parent) {
                    dfs(neighbor, current, adjacentList, subTreeNodes);
                    subTreeNodes[current] += subTreeNodes[neighbor];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();
        tFrom.add(2);
        tTo.add(1);
        tFrom.add(3);
        tTo.add(1);
        tFrom.add(4);
        tTo.add(3);
        tFrom.add(5);
        tTo.add(2);
        tFrom.add(6);
        tTo.add(1);
        tFrom.add(7);
        tTo.add(2);
        tFrom.add(8);
        tTo.add(6);
        tFrom.add(9);
        tTo.add(8);
        tFrom.add(10);
        tTo.add(8);
        System.out.println(Solution.evenForest(10, 9, tFrom, tTo));

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int tNodes = Integer.parseInt(tNodesEdges[0]);
//        int tEdges = Integer.parseInt(tNodesEdges[1]);
//
//        List<Integer> tFrom = new ArrayList<>();
//        List<Integer> tTo = new ArrayList<>();
//
//        for (int i = 0; i < tEdges; i++) {
//            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//            tFrom.add(Integer.parseInt(tFromTo[0]));
//            tTo.add(Integer.parseInt(tFromTo[1]));
//        }
//
//        int res = evenForest(tNodes, tEdges, tFrom, tTo);
//
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
