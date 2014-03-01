/**
 * 
 */
package java.practice.level3;

/**
 * @author aaronl Given an array with n objects colored red, white or blue, sort
 *         them so that objects of the same color are adjacent, with the colors
 *         in the order red, white and blue.
 * 
 *         Here, we will use the integers 0, 1, and 2 to represent the color
 *         red, white, and blue respectively.
 * 
 *         Note: You are not suppose to use the library's sort function for this
 *         problem.
 * 
 *         click to show follow up.
 * 
 *         Follow up: A rather straight forward solution is a two-pass algorithm
 *         using counting sort. First, iterate the array counting number of 0's,
 *         1's, and 2's, then overwrite array with total number of 0's, then 1's
 *         and followed by 2's.
 * 
 *         Could you come up with an one-pass algorithm using only constant
 *         space?
 */
public class SortColors {

	public void sortColors1(int[] A) {
		if (A.length < 2) {
			return;
		}
		int s = 0, e = A.length - 1;
		int i = 0;
		while (i < A.length && s < e) {
			if (A[i] == 0 && i > s) {
				while (A[s] == 0 && s < i) {
					s++;
				}
				A[i] = A[s];
				A[s] = 0;
			}

			if (A[i] == 2 && e > i) {
				while (A[e] == 2 && i < e) {
					e--;
				}
				A[i] = A[e];
				A[e] = 2;
				continue;// if A[i] == 0 need to swap again, and no need i++
			}
			i++;
		}
	}

	public void sortColors(int[] A) {
		if (A.length < 2) {
			return;
		}
		int s = 0, e = A.length - 1;
		int i = 0;
		while (i < A.length && s < e) {
			if (A[i] == 0 && i > s) {
				while (A[s] == 0 && s < i) {
					s++;
				}
				A[i] = A[s];
				A[s] = 0;
			}

			if (A[i] == 2 && e > i) {
				while (A[e] == 2 && i < e) {
					e--;
				}
				A[i] = A[e];
				A[e] = 2;

				if (A[i] == 0 && i > s) {
					while (A[s] == 0 && s < i) {
						s++;
					}
					A[i] = A[s];
					A[s] = 0;
				}
			}
			i++;
		}

	}
}
