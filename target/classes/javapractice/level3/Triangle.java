/**
 * 
 */
package java.practice.level3;

import java.util.ArrayList;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/triangle/
 * 
 * @author Aaron
 * 
 */


//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//Note:
//Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
//
//Discuss


public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int level = triangle.size();
        for (int i = level - 2; i >= 0; i--) {
            ArrayList<Integer> current = triangle.get(i);
            ArrayList<Integer> next = triangle.get(i + 1);
            for (int j = 0; j < current.size(); j++) {
                current.set(j,
                        current.get(j) + Math.min(next.get(j), next.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
