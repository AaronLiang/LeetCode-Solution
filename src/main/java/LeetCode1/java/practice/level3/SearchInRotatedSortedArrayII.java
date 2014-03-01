/**
 * 
 */
package java.practice.level3;

/**
 * Source: LeetCode
 * http://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * @author Aaron Follow up for "Search in Rotated Sorted Array": What if
 *         duplicates are allowed?
 * 
 *         Would this affect the run-time complexity? How and why?
 * 
 *         Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target)
                return true;
            if (A[start] < A[mid]) {
                if (target >= A[start] && target < A[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (A[start] > A[mid]) {
                if (target > A[mid] && target <= A[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            } else
                // skip duplicate one, A[start] == A[mid] this is very trick  why??
                start++;
        }
        return false;
    }

    public boolean search1(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        assert (A != null);
        int start = 0, end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target)
                return true;
            if (A[mid] < target) {
                if (A[end] < A[mid] || A[end] >= target)
                    start = mid + 1;
                else if (A[end] > A[mid] && A[end] < target)
                    end = mid - 1;
                else
                    end--;
            } else {
                if (A[end] > A[mid] || A[end] < target) {
                    end = mid - 1;
                } else if (A[end] < A[mid] && A[end] >= target)
                    start = mid + 1;
                else
                    end--;
            }

        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
