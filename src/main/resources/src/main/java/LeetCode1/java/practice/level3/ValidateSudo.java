/**
 * 
 */
package java.practice.level3;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/valid-sudoku/
 * 
 * @author Aaron
 * 
 *         Determine if a Sudoku is valid, according to: Sudoku Puzzles - The
 *         Rules.
 * 
 *         The Sudoku board could be partially filled, where empty cells are
 *         filled with the character '.'.
 */
public class ValidateSudo {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] mix = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int temp = board[i][j] - '1';// Trick1: - 1 casse the sudo table
                                             // no 0, the min is 1
                if (row[i][temp] == true || col[temp][j] == true
                        || mix[(i / 3) * 3 + j / 3][temp] == true) {
                    return false;
                }
                row[i][temp] = true;
                col[temp][j] = true;
                mix[(i / 3) * 3 + j / 3][temp] = true; // Trick2: this is most
                                                       // important for this
                                                       // question
            }
        }
        return true;
    }
}
