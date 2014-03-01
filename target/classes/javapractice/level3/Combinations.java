/**
 * 
 */
package java.practice.level3;

import java.util.ArrayList;

/**
 * @author aaronl
 *
 */

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
public class Combinations {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (k <= 0 || n < k) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(result, list, n, k, 1);
		return result;
	}

	public void helper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int n, int k, int s) {
		if (k == 0) {
			result.add(list);
			list = new ArrayList<Integer>();
			return;
		} else if (k > n - s + 1) {
			return;
		}

		for (int i = s; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			temp.add(i);// must have temp to copy elements from list
			helper(result, temp, n, k - 1, i + 1);
		}
	}
}
