/**
 * 
 */
package java.practice.level2;

import java.util.ArrayList;

/**
 * @author aaronl
 *
 */
// Given numRows, generate the first numRows of Pascal's triangle.
//
// For example, given numRows = 5,
// Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		result.add(list);

		for (int i = 1; i < numRows; i++) {
			list = new ArrayList<Integer>();// reset the list, can not user
											// list.clear();
			list.add(1);
			for (int j = 1; j < i; j++) {
				list.add(result.get(i - 1).get(j - 1)
						+ result.get(i - 1).get(j));
			}
			list.add(1);
			result.add(list);
		}
		return result;
	}
}
