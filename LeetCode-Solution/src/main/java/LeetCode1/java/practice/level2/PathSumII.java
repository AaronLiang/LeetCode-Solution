/**
 * 
 */
package java.practice.level2;

import java.practice.helper.TreeNode;
import java.util.ArrayList;

/**
 * Source: LeetCode
 * 
 * 
 * http://oj.leetcode.com/problems/path-sum-ii/
 * 
 * @author Aaron
 * 
 */
//
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // if(root == null){
        // return result;
        // }
        ArrayList<Integer> q = new ArrayList<Integer>();
        helper(root, result, q, sum);
        return result;
    }

    private static void helper(TreeNode root,
            ArrayList<ArrayList<Integer>> result, ArrayList<Integer> q, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        q.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<Integer>(q));
            return;
        }
        if (root.left != null) {
            helper(root.left, result, new ArrayList<Integer>(q), sum);
        }

        if (root.right != null) {
            helper(root.right, result, new ArrayList<Integer>(q), sum);
        }

    }
}
