/**
 * 
 */
package java.practice.level3;

/**
 * Source: LeetCode
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 
 * @author Aaron
 * 
 *         Follow up for "Remove Duplicates": What if duplicates are allowed at
 *         most twice?
 * 
 *         For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 *         Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] A) {
        int length = A.length;
        if (length <= 2) {
            return length;
        }

        int l = 0;
        A[l++] = A[0];
        boolean b = false;
        for (int i = 1; i < length; i++) {
            if (A[i] == A[i - 1]) {
                if (b) {
                    continue;
                } else {
                    b = true;
                }
            } else {
                b = false;
            }
            A[l++] = A[i];
        }
        return l;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
