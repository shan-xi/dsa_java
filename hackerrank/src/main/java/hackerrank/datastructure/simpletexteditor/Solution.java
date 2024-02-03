package hackerrank.datastructure.simpletexteditor;

import java.io.*;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        var bufferReader = new BufferedReader(new InputStreamReader(System.in));
        var bufferWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        var q = Integer.parseInt(bufferReader.readLine());
        var text = new StringBuilder();
        var undoStack = new Stack<String>();
        while (q-- > 0) {
            var opt = bufferReader.readLine().split(" ");
            switch (opt[0]) {
                case "1": // append
                    undoStack.push(text.toString());
                    text.append(opt[1]);
                    break;
                case "2": // delete
                    undoStack.push(text.toString());
                    text.delete(text.length() - Integer.parseInt(opt[1]), text.length());
                    break;
                case "3": // print
                    bufferWriter.write(text.charAt(Integer.parseInt(opt[1]) - 1) + "\n");
                    break;
                case "4": // undo
                    if (!undoStack.isEmpty()) {
                        text = new StringBuilder(undoStack.pop());
                    }
                    break;
            }
        }

        bufferReader.close();
        bufferWriter.close();
    }
}
