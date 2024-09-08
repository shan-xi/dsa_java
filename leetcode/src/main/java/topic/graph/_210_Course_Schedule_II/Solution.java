package topic.graph._210_Course_Schedule_II;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution cs = new Solution();

        int[][] prerequisites1 = {{1, 0}};
        int numCourses1 = 2;
        // Expected output: [0, 1]
        System.out.println("Order of courses: " + Arrays.toString(cs.findOrder(numCourses1, prerequisites1)));

        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int numCourses2 = 2;
        // Expected output: []
        System.out.println("Order of courses: " + Arrays.toString(cs.findOrder(numCourses2, prerequisites2)));

        int[][] prerequisites3 = {{0, 1}, {0, 2}, {1, 2}};
        int numCourses3 = 3;
        // Expected output: [2, 1, 0] or [1, 2, 0]
        System.out.println("Order of courses: " + Arrays.toString(cs.findOrder(numCourses3, prerequisites3)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create the graph and indegree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize the graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and indegree array
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Step 2: Find all the courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Process the queue
        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            // Decrease the indegree of the neighbors
            for (int neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Check if we have processed all courses
        if (index == numCourses) {
            return order; // Return the topological order
        } else {
            return new int[0]; // There is a cycle, so return an empty array
        }
    }
}