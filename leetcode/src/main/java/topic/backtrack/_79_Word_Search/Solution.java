package topic.backtrack._79_Word_Search;

public class Solution {
    // Main function for testing
    public static void main(String[] args) {
        Solution wordSearch = new Solution();

        // Test case 1
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        System.out.println("Word ABCCED exists: " + wordSearch.exist(board1, word1)); // Expected: true

        // Test case 2
        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word2 = "SEE";
        System.out.println("Word SEE exists: " + wordSearch.exist(board2, word2)); // Expected: true

        // Test case 3
        char[][] board3 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word3 = "ABCB";
        System.out.println("Word ABCB exists: " + wordSearch.exist(board3, word3)); // Expected: false
    }

    // Main function to check if the word exists in the board
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || word.charAt(index) != board[row][col]) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backtrack(board, word, row - 1, col, index + 1) ||
                backtrack(board, word, row + 1, col, index + 1) ||
                backtrack(board, word, row, col - 1, index + 1) ||
                backtrack(board, word, row, col + 1, index + 1);

        board[row][col] = temp;
        return found;
    }
}
