package hackerrank.datastructure.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

    public static List<Integer> contacts(List<List<String>> queries) {
        TrieNode root = new TrieNode();
        List<Integer> result = new ArrayList<>();

        for (List<String> query : queries) {
            String operation = query.get(0);
            String character = query.get(1);
            if (operation.equals("add")) {
                addContacts(root, character);
            } else if (operation.equals("find")) {
                int count = findContacts(root, character);
                result.add(count);
            }
        }

        return result;
    }

    private static int findContacts(TrieNode root, String content) {
        TrieNode current = root;
        for (char ch : content.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return 0;
            }
            current = current.children.get(ch);
        }
        return current.count;
    }

    private static void addContacts(TrieNode root, String content) {
        TrieNode current = root;
        for (char ch : content.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
            current.count++;
        }
    }


    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("add", "ed"));
        queries.add(List.of("add", "eddie"));
        queries.add(List.of("add", "edward"));
        queries.add(List.of("find", "ed"));
        queries.add(List.of("add", "edwina"));
        queries.add(List.of("find", "edw"));
        queries.add(List.of("find", "a"));
        List<Integer> result = Result.contacts(queries);
        System.out.println(result);

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<String>> queries = new ArrayList<>();
//
//        IntStream.range(0, queriesRows).forEach(i -> {
//            try {
//                queries.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        List<Integer> result = Result.contacts(queries);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
