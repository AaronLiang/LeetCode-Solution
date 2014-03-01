/**
 * 
 */
package java.practice.level3;

import java.practice.helper.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * @author Aaron
 * 
 */

//Given a binary tree, return the zigzag level order traversal of its nodes' values. 
//(ie, from left to right, then right to left for the next level and alternate between).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        ArrayList<Integer> level = new ArrayList<Integer>();
        boolean b = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (b) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                    result.add(level);
                    level = new ArrayList<Integer>();
                    b = !b;
                } else {
                    result.add(level);// Trick1: add the last level before
                                      // return
                    return result;
                }
            }
        }
        return result;
    }
}
