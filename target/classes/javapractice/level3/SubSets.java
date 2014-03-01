/**
 * 
 */
package java.practice.level3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/subsets/
 * 
 * @author Aaron
 * 
 * 
 *         Given a set of distinct integers, S, return all possible subsets.
 * 
 *         Note: Elements in a subset must be in non-descending order. The
 *         solution set must not contain duplicate subsets. For example, If S =
 *         [1,2,3], a solution is:
 */
public class SubSets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) {
            return result;
        }
        Arrays.sort(S);
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < S.length; i++) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> list : result) {

                lists.add(new ArrayList<Integer>(list));// copy the oringnal and
                list.add(S[i]);// changed the orignal list(reference)
            }
            result.addAll(lists);
        }
        return result;

    }
}
