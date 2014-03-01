/**
 * 
 */
package java.practice.level3;

import java.practice.helper.TreeNode;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * @author Aaron
 * 
 */
//Given a binary tree, flatten it to a linked list in-place.
//
//For example,
//Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6
//click to show hints.
//
//Hints:
//If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
            TreeNode temp2 = root;
            while (temp2.right != null) {
                temp2 = temp2.right;
            }
            temp2.right = temp;
            flatten(root);
        }
        if (root.right != null) {// Trick: if left == null, check right side
            flatten(root.right);
        }

    }
}
