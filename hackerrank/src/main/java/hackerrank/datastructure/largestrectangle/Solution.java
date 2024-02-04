package hackerrank.datastructure.largestrectangle;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < h.size(); i++) {
            while (!stack.isEmpty() && h.get(i) < h.get(stack.peek())) {
                int height = h.get(stack.pop());
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = h.get(stack.pop());
            int width = stack.isEmpty() ? h.size() : h.size() - stack.peek() - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> h = List.of(5, 4, 3, 2, 1);
        long result = Result.largestRectangle(h);
        System.out.println(result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        long result = Result.largestRectangle(h);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
