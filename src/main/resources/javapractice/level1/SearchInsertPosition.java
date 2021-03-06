/**
 * 
 */
package java.practice.level1;

/**
 * @author aaronl
 * 
 *         Given a sorted array and a target value, return the index if the
 *         target is found. If not, return the index where it would be if it
 *         were inserted in order. You may assume no duplicates in the array.
 */
// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

public class SearchInsertPosition {

	/**
	 * 
	 */
	public SearchInsertPosition() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int searchInsert(int[] A, int target) {
		if (A.length == 0) {
			return 0;
		}

		for (int i = 0; i < A.length; i++) {
			if (target > A[i]) {
				continue;
			}
			return i;
		}
		return A.length;
	}

}
