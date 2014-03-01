/**
 * 
 */
package java.practice.level3;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 * 
 *         Given a sorted array of integers, find the starting and ending
 *         position of a given target value.
 * 
 *         Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 *         If the target is not found in the array, return [-1, -1].
 * 
 *         For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3,
 *         4].
 * 
 *         这道题需要终止条件i<j, mid取向两种都需要用到，分半的时候需要用到=mid。我发现一般＝mid的时候，终止条件往往是i<j,
 *         不然会有死循环。
 */
public class SearchForARange {

	public int[] searchRange(int[] A, int target) {
		int[] r = { -1, -1 };
		int s = 0, e = A.length - 1;
		int mid = 0;
		while (s <= e) {// care about the "=", if there [1, 4], 4
			mid = (s + e) / 2;
			if (A[mid] == target) {
				break;
			} else if (A[mid] < target) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		s = mid;
		e = mid;
		while (s >= 0 && A[s] == target) {
			--s;
		}

		while (e < A.length && A[e] == target) {
			++e;
		}
		if (s == mid && e == mid)
			return r;

		r[0] = ++s;// remember move back
		r[1] = --e;
		return r;
	}
}
