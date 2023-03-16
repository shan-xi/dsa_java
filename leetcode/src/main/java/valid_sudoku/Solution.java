package valid_sudoku;

import java.util.HashMap;
import java.util.HashSet;

// 36. Valid Sudoku
// https://leetcode.com/problems/valid-sudoku/?envType=study-plan&id=data-structure-i
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] boxSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
            boxSet[i] = new HashSet<Character>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                char c = board[i][j];
                if (rowSet[i].contains(c) || colSet[j].contains(c) || boxSet[(i / 3) * 3 + j / 3].contains(c)) {
                    return false;
                }
                rowSet[i].add(c);
                colSet[j].add(c);
                boxSet[(i / 3) * 3 + j / 3].add(c);
            }
        }
        return true;
    }
//    public boolean isValidSudoku(char[][] board) {
//        HashMap<Character, Boolean> map = new HashMap<>();
//        int rows = board.length;
//        int cols = board[0].length;
//        for (int i = 0; i < rows; i++) {
//            map.clear();
//            for (int j = 0; j < cols; j++) {
//                if (board[i][j] == '.') continue;
//                if (map.containsKey(board[i][j])) {
//                    System.out.println("row detect:" + i + " " + j + " " + board[i][j]);
//                    return false;
//                }
//                map.put(board[i][j], true);
//            }
//        }
//        for (int i = 0; i < cols; i++) {
//            map.clear();
//            for (int j = 0; j < rows; j++) {
//                if (board[j][i] == '.') continue;
//                if (map.containsKey(board[j][i])) {
//                    System.out.println("col detect:" + j + " " + i + " " + board[j][i]);
//                    return false;
//                }
//                map.put(board[j][i], true);
//            }
//        }
//        int i = 0;
//        int j = 0;
//        int x = 0;
//        int y = 0;
//        while (i < rows) {
//            x = i + 3;
//            while (j < cols) {
//                y = j + 3;
//                map.clear();
//                for (int p = i; p < x; p++) {
//                    for (int q = j; q < y; q++) {
//                        if (board[p][q] == '.') continue;
//                        if (map.containsKey(board[p][q])) {
//                            System.out.println("nine detect: " + p + " " + q + " " + board[p][q]);
//                            return false;
//                        }
//                        map.put(board[p][q], true);
//                    }
//                }
//                System.out.println("end: " + x + " " + y);
//
//                j += 3;
//            }
//            j = 0;
//            i += 3;
//        }
//        return true;
//    }
}
