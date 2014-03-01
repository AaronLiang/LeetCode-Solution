/**
 * 
 */
package java.practice.level4;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         Given a m x n matrix, if an element is 0, set its entire row and
 *         column to 0. Do it in place.
 * 
 *         click to show follow up.
 * 
 *         Follow up: Did you use extra space? A straight forward solution using
 *         O(mn) space is probably a bad idea. A simple improvement uses O(m +
 *         n) space, but still not the best solution. Could you devise a
 *         constant space solution?
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) {
            return;
        }
        int c = matrix[0].length;

        if (r == 1 && c == 1) {
            return;
        }

        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int m = 0;
        while (m < c) {
            for (int i = 0; i < r && col[m]; i++) {// trick: col[m] == true
                matrix[i][m] = 0;
            }
            m++;
        }

        int n = 0;
        while (n < r) {
            for (int k = 0; k < c && row[n]; k++) {
                matrix[n][k] = 0;
            }
            n++;
        }

    }
}
