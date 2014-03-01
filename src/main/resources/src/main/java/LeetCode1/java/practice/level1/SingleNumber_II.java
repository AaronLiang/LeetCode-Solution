/**
 * 
 */
package java.practice.level1;

import java.util.Arrays;

/**
 * @author aaronl
 * 
 *         Given an array of integers, every element appears three times except
 *         for one. Find that single one.
 * 
 *         Note: Your algorithm should have a linear runtime complexity. Could
 *         you implement it without using extra memory?
 */
public class SingleNumber_II {

	public int singleNumber(int[] A) {
		if (A.length < 3) {
			return A[0];
		}
		Arrays.sort(A);
		for (int i = 2; i < A.length; i = i + 3) {
			if (A[i - 2] != A[i - 1]) {
				return A[i - 2];
			}
		}
		return A[A.length - 1];
	}
}
