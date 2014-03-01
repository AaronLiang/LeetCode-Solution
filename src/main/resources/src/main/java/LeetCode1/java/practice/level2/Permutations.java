/**
 * 
 */
package java.practice.level2;

import java.util.ArrayList;

/**
 * @author aaronl
 * 
 *         Given a collection of numbers, return all possible permutations.
 * 
 *         For example, [1,2,3] have the following permutations: [1,2,3],
 *         [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int length = num.length;
		if (length == 0) {
			return result;
		}

		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(num[0]);
		result.add(array);
		for (int i = 1; i < length; i++) {
			ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
			while (!result.isEmpty()) {
				array = result.remove(0);// remove must have a index or object
				for (int j = 0; j <= i; j++) {
					ArrayList<Integer> temp = new ArrayList<Integer>(array);
					temp.add(j, num[i]);
					lists.add(temp);
				}
			}
			result = lists;
		}
		return result;
	}
}
