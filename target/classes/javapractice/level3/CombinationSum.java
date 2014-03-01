/**
 * 
 */
package java.practice.level3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/combination-sum/
 * 
 * @author Aaron
 * 
 * 
 *         Given a set of candidate numbers (C) and a target number (T), find
 *         all unique combinations in C where the candidate numbers sums to T.
 * 
 *         The same repeated number may be chosen from C unlimited number of
 *         times.
 * 
 *         Note: All numbers (including target) will be positive integers.
 *         Elements in a combination (a1, a2, … , ak) must be in non-descending
 *         order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain
 *         duplicate combinations. For example, given candidate set 2,3,6,7 and
 *         target 7, A solution set is: [7] [2, 2, 3]
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
            int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // result.add(new ArrayList<Integer>());
        if (candidates != null && candidates.length != 0 && target > 0) {
            Arrays.sort(candidates);
            helper(candidates, target, 0, result, new ArrayList<Integer>());
        }

        return result;
    }

    private static void helper(int[] candidates, int target, int k,
            ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if (target == 0) {
            result.add(temp);
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = k; i < candidates.length; i++) {
                @SuppressWarnings("unchecked")
                ArrayList<Integer> list = (ArrayList<Integer>) temp.clone();// new
                                                                            // ArrayList(temp)
                list.add(candidates[i]);
                helper(candidates, target - candidates[i], i, result, list);
            }
        }
    }
}
