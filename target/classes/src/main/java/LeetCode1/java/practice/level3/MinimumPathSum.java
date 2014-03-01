/**
 * 
 */
package java.practice.level3;

/**
 * @author aaronl
 * 
 * 
 *         Given a m x n grid filled with non-negative numbers, find a path from
 *         top left to bottom right which minimizes the sum of all numbers along
 *         its path.
 * 
 *         Note: You can only move either down or right at any point in time.
 * 
 *         Discuss
 */
public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		// if(m ==1 && n == 1){
		// return grid[0][0];
		// }
		int[][] sum = new int[m][n];
		sum[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			sum[i][0] = sum[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			sum[0][j] = sum[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
			}
		}

		return sum[m - 1][n - 1];
	}
}
