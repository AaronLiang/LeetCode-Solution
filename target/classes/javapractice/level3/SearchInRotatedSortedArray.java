/**
 * 
 */
package java.practice.level3;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author Aaron
 * 
 *         Suppose a sorted array is rotated at some pivot unknown to you
 *         beforehand.
 * 
 *         (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 *         You are given a target value to search. If found in the array return
 *         its index, otherwise return -1.
 * 
 *         You may assume no duplicate exists in the array.
 * 
 *         Discuss
 */
public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        if (A.length < 2) {
            return A[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == A[m]) {
                return m;
            }
            if (A[l] <= A[m]) {
                if (target >= A[l] && target < A[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target <= A[r] && target > A[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
