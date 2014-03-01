/**
 * 
 */
package java.practice.level3;

/**
 * @author aaronl
 * 
 * 
 *         Given two sorted integer arrays A and B, merge B into A as one sorted
 *         array.
 * 
 *         Note: You may assume that A has enough space to hold additional
 *         elements from B. The number of elements initialized in A and B are m
 *         and n respectively.
 */
public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) {
		while (n > 0) {
			if (m > 0 && A[m - 1] > B[n - 1]) {// Attention m-1 and n-1
				A[--m + n] = A[m];
			} else {
				A[m + --n] = B[n];
			}
		}
	}

}
