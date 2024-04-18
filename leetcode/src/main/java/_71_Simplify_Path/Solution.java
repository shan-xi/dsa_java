package _71_Simplify_Path;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.simplifyPath("/home/")); // /home
        System.out.println(s.simplifyPath("/../")); // /
        System.out.println(s.simplifyPath("/home//foo/")); // /home/foo
        System.out.println(s.simplifyPath("/home/../foo/")); // /foo
        System.out.println(s.simplifyPath("/home/./foo/")); // /home/foo
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> skip = Set.of("..", ".", "");
        for (var dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        var sb = new StringBuilder();
        for (var s : stack) {
            sb.insert(0, "/" + s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}

