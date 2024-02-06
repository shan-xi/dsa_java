package hackerrank.algorithms.thegridsearch;

import java.io.IOException;
import java.util.List;

class Result {

    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
        int rowG = G.size();
        int colG = G.get(0).length();
        int rowP = P.size();
        int colP = P.get(0).length();

        for (int i = 0; i <= rowG - rowP; i++) {
            for (int j = 0; j <= colG - colP; j++) {
                boolean found = true;
                if (G.get(i).substring(j, j + colP).equals(P.get(0))) {
                    for (int k = 1; k < rowP; k++) {
                        if (!G.get(i + k).substring(j, j + colP).equals(P.get(k))) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> G = List.of(
                "1234567890",
                "0987654321",
                "1111111111",
                "1111111111",
                "2222222222"
        );
        List<String> P = List.of(
                "876543",
                "111111",
                "111111"
        );
        String result = Result.gridSearch(G, P);
        System.out.println(result);

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                int R = Integer.parseInt(firstMultipleInput[0]);
//
//                int C = Integer.parseInt(firstMultipleInput[1]);
//
//                List<String> G = IntStream.range(0, R).mapToObj(i -> {
//                            try {
//                                return bufferedReader.readLine();
//                            } catch (IOException ex) {
//                                throw new RuntimeException(ex);
//                            }
//                        })
//                        .collect(toList());
//
//                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                int r = Integer.parseInt(secondMultipleInput[0]);
//
//                int c = Integer.parseInt(secondMultipleInput[1]);
//
//                List<String> P = IntStream.range(0, r).mapToObj(i -> {
//                            try {
//                                return bufferedReader.readLine();
//                            } catch (IOException ex) {
//                                throw new RuntimeException(ex);
//                            }
//                        })
//                        .collect(toList());
//
//                String result = Result.gridSearch(G, P);
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
