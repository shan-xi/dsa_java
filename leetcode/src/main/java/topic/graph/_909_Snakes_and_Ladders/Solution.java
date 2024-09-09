package topic.graph._909_Snakes_and_Ladders;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Test function
    public static void main(String[] args) {
        Solution game = new Solution();

        int[][] board1 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        // Expected output: 4 (1 -> 2 -> 3 -> 13 -> 36)
        System.out.println("Minimum moves: " + game.snakesAndLadders(board1));

        int[][] board2 = {
                {-1, -1, -1, 1, -1},
                {2, 2, 2, 2, 2},
                {-1, -1, -1, -1, -1},
                {-1, 10, -1, -1, 12},
                {-1, -1, -1, -1, 14}
        };
        // Expected output: -1 (impossible to reach)
        System.out.println("Minimum moves: " + game.snakesAndLadders(board2));
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); // Start from square 1, with 0 moves

        // While there are positions to explore
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int square = current[0];
            int moves = current[1];

            // If we have reached the last square, return the number of moves
            if (square == n * n) {
                return moves;
            }

            // Try all possible dice rolls (1 to 6)
            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;

                // Ensure the next square is valid
                if (nextSquare > n * n) break;

                // Get the board position (handling snakes and ladders)
                int[] position = getBoardPosition(nextSquare, n);
                int row = position[0], col = position[1];

                // If the board has a ladder or snake, move to the destination
                if (board[row][col] != -1) {
                    nextSquare = board[row][col];
                }

                // If this square has not been visited
                if (!visited[nextSquare]) {
                    visited[nextSquare] = true;
                    queue.add(new int[]{nextSquare, moves + 1});
                }
            }
        }

        // If we cannot reach the last square, return -1
        return -1;
    }

    // Helper function to convert a square number to board coordinates
    private int[] getBoardPosition(int square, int n) {
        int row = (square - 1) / n;
        int col = (square - 1) % n;

        // Adjust for the zigzag pattern on the board
        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[]{n - 1 - row, col};
    }
}
