/**
 * 
 */
package java.practice.level4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/subsets-ii/
 * 
 * @author Aaron
 * 
 *         Given a collection of integers that might contain duplicates, S,
 *         return all possible subsets.
 * 
 *         Note: Elements in a subset must be in non-descending order. The
 *         solution set must not contain duplicate subsets. For example, If S =
 *         [1,2,2], a solution is:
 * 
 *         [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class SubSetII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if (S == null || S.length == 0) {
            return result;
        }
        Arrays.sort(S);
        result.add(new ArrayList<Integer>(Arrays.asList(S[0])));// this line
                                                                // just test
                                                                // asList API
        for (int i = 1; i < S.length; i++) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> arr : result) {
                ArrayList<Integer> temp = new ArrayList<Integer>(arr);
                temp.add(S[i]);
                list.add(temp);
            }
            for (ArrayList<Integer> arr : list) {
                if (!result.contains(arr)) {// how this works? arr is an object,
                                            // every time it has different
                                            // reference, even contains the same
                                            // elements
                    result.add(arr);
                }
            }
        }
        return result;
    }

    // niubility solution
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {

        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());

        int start = 0;
        for (int i = 0; i < num.length; i++) {
            int size = ret.size();
            for (int j = start; j < size; j++) {
                ArrayList<Integer> sub = new ArrayList<Integer>(ret.get(j));
                sub.add(num[i]);
                ret.add(sub);
            }
            if (i < num.length - 1 && num[i + 1] == num[i])// this is so so
                                                           // niubility
                start = size;
            else
                start = 0;
        }

        return ret;
    }
}
