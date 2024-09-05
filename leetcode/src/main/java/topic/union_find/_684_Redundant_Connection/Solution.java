package topic.union_find._684_Redundant_Connection;

import java.util.Arrays;

public class Solution {
    // Test function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};

        // Expected output: [2, 3]
        System.out.println("Redundant edge: " + Arrays.toString(solution.findRedundantConnection(edges1)));

        // Expected output: [1, 4]
        System.out.println("Redundant edge: " + Arrays.toString(solution.findRedundantConnection(edges2)));
    }

    // Find with path compression
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    // Union two sets
    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            // Union by rank to keep tree balanced
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        // Initialize each node to be its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Iterate through each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // If u and v are already connected, return this edge
            if (rootU == rootV) {
                return edge;
            } else {
                union(parent, rank, u, v);
            }
        }

        // This shouldn't happen, because we are guaranteed to have a redundant connection
        return new int[0];
    }
}
