package topic.graph._207_Course_Schedule;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution cs = new Solution();

        int[][] prerequisites1 = {{1, 0}};
        int numCourses1 = 2;
        // Expected output: true (no cycles, can finish all courses)
        System.out.println("Can finish all courses: " + cs.canFinish(numCourses1, prerequisites1));

        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int numCourses2 = 2;
        // Expected output: false (cycle exists)
        System.out.println("Can finish all courses: " + cs.canFinish(numCourses2, prerequisites2));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        // Step 2: Create visited and onPath arrays
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        // Step 3: Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, visited, onPath, i)) {
                return false;  // Cycle detected
            }
        }

        // No cycle detected, we can finish all courses
        return true;
    }

    // Helper function to detect cycles using DFS
    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] onPath, int course) {
        // If this node is on the current DFS path, there's a cycle
        if (onPath[course]) {
            return true;
        }

        // If this node has been fully visited, no need to check again
        if (visited[course]) {
            return false;
        }

        // Mark this node as visited and on the current path
        visited[course] = true;
        onPath[course] = true;

        // Recurse on all neighbors (courses that depend on the current course)
        for (int neighbor : graph.get(course)) {
            if (hasCycle(graph, visited, onPath, neighbor)) {
                return true;
            }
        }

        // Backtrack: remove this node from the current path
        onPath[course] = false;

        return false;
    }
}
