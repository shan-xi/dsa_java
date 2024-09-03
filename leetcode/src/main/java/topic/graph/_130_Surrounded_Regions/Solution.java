package topic.graph._130_Surrounded_Regions;

public class Solution {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test case 1
        char[][] board1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solver.solve(board1);
        printBoard(board1);
        // Expected output:
        // X X X X
        // X X X X
        // X X X X
        // X O X X

        // Test case 2
        char[][] board2 = {
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solver.solve(board2);
        printBoard(board2);
        // Expected output:
        // X O X X
        // X O O X
        // X O X X
        // X O X X
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Mark 'O's on the boundary and their connected 'O's
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                markSafe(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                markSafe(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                markSafe(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                markSafe(board, rows - 1, j);
            }
        }

        // Flip the rest of the 'O's to 'X's and revert '*' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markSafe(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '*';  // Mark as safe

        // Explore all 4 directions
        markSafe(board, i - 1, j);
        markSafe(board, i + 1, j);
        markSafe(board, i, j - 1);
        markSafe(board, i, j + 1);
    }

}
