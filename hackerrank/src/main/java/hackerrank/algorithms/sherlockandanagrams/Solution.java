package hackerrank.algorithms.sherlockandanagrams;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int sherlockAndAnagrams(String s) {
        var result = 0;
        var fq = new HashMap<String, Integer>();
        for (var i = 0; i < s.length(); i++) {
            for (var j = i + 1; j <= s.length(); j++) {
                var substring = s.substring(i, j).toCharArray();
                Arrays.sort(substring);
                var sortedSubstring = new String(substring);
                fq.put(sortedSubstring, fq.getOrDefault(sortedSubstring, 0) + 1);
            }
        }
        for (var count : fq.values()) {
            result += count * (count - 1) / 2;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
