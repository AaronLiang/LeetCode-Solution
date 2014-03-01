/**
 * 
 */
package java.practice.level4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/combination-sum-ii/
 * 
 * @author Aaron
 * 
 *         Given a collection of candidate numbers (C) and a target number (T),
 *         find all unique combinations in C where the candidate numbers sums to
 *         T.
 * 
 *         Each number in C may only be used once in the combination.
 * 
 *         Note: All numbers (including target) will be positive integers.
 *         Elements in a combination (a1, a2, … , ak) must be in non-descending
 *         order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain
 *         duplicate combinations. For example, given candidate set
 *         10,1,2,7,6,1,5 and target 8, A solution set is: [1, 7] [1, 2, 5] [2,
 *         6] [1, 1, 6]
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum3(int[] num, int target) {
        return null;
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
            int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // result.add(new ArrayList<Integer>());
        if (candidates != null && candidates.length != 0 && target > 0
                && candidates.length < 300) {
            Arrays.sort(candidates);
            helper(candidates, target, 0, result, new ArrayList<Integer>());
        }

        return result;
    }

    private static void helper(int[] candidates, int target, int k,
            ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if (target == 0) {
            if (!result.contains(temp)) {
                result.add(temp);
            }
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = k; i < candidates.length; i++) {
                if (i > k && candidates[i] == candidates[i - 1]) {
                    // Trick: performance issue check when i > k, skip the
                    // duplicate
                    continue;
                }
                ArrayList<Integer> list = (ArrayList<Integer>) temp.clone();// new
                                                                            // ArrayList(temp)
                list.add(candidates[i]);
                helper(candidates, target - candidates[i], i + 1, result, list);
            }
        }
    }
}
