/**
 * 
 */
package java.practice.level3;

/**
 * @author aaronl
 * 
 *         Rotate the image by 90 degrees (clockwise).
 * 
 *         Follow up: Could you do this in-place?
 */
public class RotateImage {

	public void rotate1(int[][] matrix) {
		int m = matrix.length;
		if (m < 2) {
			return;
		}
		int n = matrix[0].length;
		m--;
		n--;
		for (int i = 0; i <= m; i++) {
			for (int j = i + 1; j <= n - i; j++) {// the outside first then go inside
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j][i];
				matrix[n - j][i] = matrix[m - i][n - j];
				matrix[m - i][n - j] = matrix[j][m - i];
				matrix[j][m - i] = temp;
			}
		}

	}

	public void rotate(int[][] matrix) {
		int m = matrix.length - 1;
		if (m < 0) {
			return;
		}
		int n = matrix[0].length - 1;
		int[][] temp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				temp[i][j] = matrix[n - j][i];
			}
		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				matrix[i][j] = temp[i][j];
			}
		}
	}
}
