/**
 * 
 */
package LeetCode1.java.practice.error;

import java.util.ArrayList;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/permutations-ii/
 * 
 * @author Aaron
 * 
 *         Given a collection of numbers that might contain duplicates, return
 *         all possible unique permutations.
 * 
 *         For example, [1,1,2] have the following unique permutations: [1,1,2],
 *         [1,2,1], and [2,1,1].
 */
public class PermutationII_TimeLimitedExceeded {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int length = num.length;
        if (length == 0) {
            return result;
        }

        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(num[0]);
        result.add(array);
        for (int i = 1; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
            while (!result.isEmpty()) {
                array = result.remove(0);
                for (int j = 0; j <= i; j++) {
                    @SuppressWarnings("unchecked")
                    ArrayList<Integer> temp = (ArrayList<Integer>) array
                            .clone();
                    // if((temp.indexOf(num[i]) == j) ||
                    // (j < 0 && temp.indexOf(num[i]) == j-1)){
                    // continue;
                    // }
                    //
                    // if(j < temp.size() && num[i] == temp.get(j)) continue;//
                    // why can not use this one
                    temp.add(j, num[i]);
                    lists.add(temp);
                }
            }
            for (ArrayList<Integer> temp : lists) {
                if (result.contains(temp)) {
                    continue;
                }
                result.add(temp);
            }
        }
        return result;
    }
}
