package hackerrank.datastructure.swapnodes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        Node root = buildTree(indexes);

        for (int k : queries) {
            swapNodes(root, k, 1);
            List<Integer> traversal = inOrderTraversal(root);
            result.add(traversal);
        }

        return result;
    }

    private static Node buildTree(List<List<Integer>> indexes) {
        int n = indexes.size();
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            int leftIdx = indexes.get(i).get(0);
            int rightIdx = indexes.get(i).get(1);

            if (leftIdx != -1) {
                nodes[i + 1].left = nodes[leftIdx];
            }

            if (rightIdx != -1) {
                nodes[i + 1].right = nodes[rightIdx];
            }
        }

        return nodes[1]; // Return the root of the tree
    }

    private static List<Integer> inOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.data);
            current = current.right;
        }
        return result;
    }

    private static void swapNodes(Node root, int k, int depth) {
        if (root == null) {
            return;
        }
        if (depth % k == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        swapNodes(root.left, k, depth + 1);
        swapNodes(root.right, k, depth + 1);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
