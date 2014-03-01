/**
 * 
 */
package java.practice.level3;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/search-a-2d-matrix/
 * 
 * @author Aaron
 * 
 * 
 *         Write an efficient algorithm that searches for a value in an m x n
 *         matrix. This matrix has the following properties:
 * 
 *         Integers in each row are sorted from left to right. The first integer
 *         of each row is greater than the last integer of the previous row. For
 *         example,
 * 
 *         Consider the following matrix:
 */
//[
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//Given target = 3, return true.

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        long size = row * col;

        long start = 0, end = size - 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            int r = (int) (mid / col);
            int c = (int) (mid % col);
            // if (c < 0 || r < 0){
            // start++;
            // continue;
            // }
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
