/**
 * 
 */
package java.practice.level4;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 * 
 *         Given an unsorted integer array, find the first missing positive
 *         integer.
 * 
 *         For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 *         Your algorithm should run in O(n) time and uses constant space.
 */

// We need to pay attention to two constraints, 1) Constant additional space.
// 2)O(n) time cost. So we can't sort the array first and can't copy the array
// to another array. While the key point here, is to find the first missing
// positive integer of the array. So we can make use of the index. We iterate
// through the whole array, to store A[i] = i+1, if i+1 exists in the array. We
// do the swap.
//
// In the swap loop, we need to be careful.
// In the first, my loop is
// for( int i=0; i<n; i++)
// {
// if(A[i]<n&&A[i]>0)
// swap(A[i], A[A[i]-1]);
// }
//
// In this case, it will miss some elements in the array. For example, -1, 4, 2,
// 1, 9, 10. After first swap, A[3]=4, A[1]=1. So 1 will be missed to be
// swapped. So the loop here is very important.

public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}

		for (int i = 0; i < A.length; i++) {
			while ((A[i] != i + 1) && (A[i] < A.length) && (A[i] > 0)
					&& (A[A[i] - 1] != A[i])) {
				// why use while not if??? care about checking the index
				// range[0,length)
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;

			}
		}
		int i = 0;

		while (i < A.length && A[i] == i + 1) {
			i++;
		}
		return i + 1;
	}

	public int firstMissingPositive1(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}

		int[] checkList = new int[Integer.MAX_VALUE];
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			checkList[i] = 0;
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				checkList[A[i] - 1] = A[i];
			}
		}

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (checkList[i] != i + 1) {
				return i + 1;
			}
		}
		return Integer.MAX_VALUE;

	}
}
