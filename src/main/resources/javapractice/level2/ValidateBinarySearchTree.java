/**
 * 
 */
package java.practice.level2;

import java.practice.helper.TreeNode;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/validate-binary-search-tree/
 * 
 * @author Aaron
 * 
 *         Given a binary tree, determine if it is a valid binary search tree
 *         (BST).
 * 
 *         Assume a BST is defined as follows:
 * 
 *         The left subtree of a node contains only nodes with keys less than
 *         the node's key. The right subtree of a node contains only nodes with
 *         keys greater than the node's key. Both the left and right subtrees
 *         must also be binary search trees. confused what "{1,#,2,3}" means? >
 *         read more on how binary tree is serialized on OJ.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        return helper(root.left, min, root.val)
                && helper(root.right, root.val, max);
    }

    private static boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val > min && root.val < max) {
            return helper(root.left, min, root.val)
                    && helper(root.right, root.val, max);
        } else {
            return false;
        }
    }
}
