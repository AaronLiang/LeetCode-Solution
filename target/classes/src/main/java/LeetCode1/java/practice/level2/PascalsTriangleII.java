/**
 * 
 */
package java.practice.level2;

import java.util.ArrayList;

/**
 * Source: LeetCode
 * 
 * @author Aaron Given an index k, return the kth row of the Pascal's triangle.
 * 
 *         For example, given k = 3, Return [1,3,3,1].
 * 
 *         Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            t.addAll(result);
            result.clear();
            result.add(1);
            for (int j = 1; j < i; j++) {
                result.add(t.get(j - 1) + t.get(j));
            }
            result.add(1);
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
