package topic.stack._71_Simplify_Path;

import java.util.Stack;

public class Solution {
    // Main function for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String path1 = "/home/";
        String path2 = "/../";
        String path3 = "/home//foo/";
        String path4 = "/a/./b/../../c/";
        String path5 = "/a/../../b/../c//.//";
        String path6 = "/a//b////c/d//././/..";

        System.out.println(solution.simplifyPath(path1)); // Output: "/home"
        System.out.println(solution.simplifyPath(path2)); // Output: "/"
        System.out.println(solution.simplifyPath(path3)); // Output: "/home/foo"
        System.out.println(solution.simplifyPath(path4)); // Output: "/c"
        System.out.println(solution.simplifyPath(path5)); // Output: "/c"
        System.out.println(solution.simplifyPath(path6)); // Output: "/a/b/c"
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;  // Skip empty and current directory references
            }
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();  // Move up to the parent directory
                }
            } else {
                stack.push(component);  // Add valid directory name to the stack
            }
        }

        // Reconstruct the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        return !simplifiedPath.isEmpty() ? simplifiedPath.toString() : "/";
    }
}
