/**
 * 
 */
package java.practice.level5;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * @author Aaron
 * 
 *         There are two sorted arrays A and B of size m and n respectively.
 *         Find the median of the two sorted arrays. The overall run time
 *         complexity should be O(log (m+n)).
 * 
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {// lg(m+n)
        int la = A.length;
        int lb = B.length;
        if ((la + lb) % 2 == 0) {
            return (findKth(A, B, (la + lb) / 2, 0, la - 1) + findKth(A, B,
                    (la + lb) / 2 + 1, 0, la - 1)) / 2.0;// Trick1: ((la + lb)/2
                                                         // + 1) not -1
        }
        return findKth(A, B, (la + lb) / 2 + 1, 0, la - 1);
    }

    private static int findKth(int[] A, int[] B, int k, int start, int end) {
        @SuppressWarnings("unused")
        int la = A.length;
        int lb = B.length;
        if (start > end) {
            return findKth(B, A, k, 0, lb - 1);
        }

        int mid = (start + end) / 2;
        int remain = k - 1 - mid - 1;// why -2??
        if ((remain < 0 || (remain < lb && A[mid] >= B[remain]))
                && (remain >= lb - 1 || (remain + 1 >= 0 && A[mid] <= B[remain + 1]))) {
            return A[mid];
        } else if (remain < 0 || (remain < lb && A[mid] > B[remain])) {
            return findKth(A, B, k, start, mid - 1);
        } else {
            return findKth(A, B, k, mid + 1, end);
        }
    }

    public double findMedianSortedArrays1(int A[], int B[]) {// O(m + n) merge
                                                             // sorted arrys
        int la = A.length;
        int lb = B.length;
        int[] m = new int[la + lb];

        if (la == 0 && lb == 0) {
            return -1;
        } else if (la == 0) {
            return lb % 2 == 0 ? (B[lb / 2] + B[lb / 2 - 1]) / 2.0 : B[lb / 2];
        } else if (lb == 0) {
            return la % 2 == 0 ? (A[la / 2] + A[la / 2 - 1]) / 2.0 : A[la / 2];
        }

        la--;
        lb--;
        while (la >= 0 || lb >= 0) {
            if (la >= 0 && lb >= 0) {
                m[la + lb + 1] = A[la] > B[lb] ? A[la--] : B[lb--];
            } else if (la >= 0) {
                m[la] = A[la--];
            } else {
                m[lb] = B[lb--];
            }
        }

        la = A.length;
        lb = B.length;
        if ((la + lb) % 2 == 0) {
            return (m[(la + lb) / 2] + m[(la + lb) / 2 - 1]) / 2.0;
        }
        return m[(la + lb) / 2];// can not use l/2 + 1

    }
}
