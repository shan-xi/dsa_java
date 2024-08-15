package topic.stack._71_Simplify_Path;

import java.util.Stack;

public class MySolution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p == null || p.isEmpty() || p.equals(".")) continue;
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(p);
        }
        for (String s : stack) {
            result.append("/").append(s);
        }
        if (result.isEmpty()) {
            return "/";
        } else {
            return result.toString();
        }
    }
}
