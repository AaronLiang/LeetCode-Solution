/**
 * 
 */
package java.practice.level1;

import java.practice.helper.TreeNode;

/**
 * @author aaronl
 *
 */

// Given a binary tree, check whether it is a mirror of itself (ie, symmetric
// around its center).
//
// For example, this binary tree is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.
//
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized
// on OJ.
//
//
// OJ's Binary Tree Serialization:
// The serialization of a binary tree follows a level order traversal, where '#'
// signifies a path terminator where no node exists below.
//
// Here's an example:
//   1
//  / \
// 2   3
//    /
//   4
//    \
//     5
//The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
public class SymmetricTree {
	
	public boolean helper1(TreeNode node1, TreeNode node2) {
		if (node1 == null) {
			return node2 == null;
		} else if (node2 == null) {
			return false;
		} else if (node1.val != node2.val) {
			return false;
		} else {
			return helper(node1.left, node2.right)
					&& helper(node1.right, node2.left);
		}
	}
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	public boolean helper(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 == null || node2 == null) {
			return false;
		} else if (node1.val != node2.val) {
			return false;
		} else {
			return helper(node1.left, node2.right)
					&& helper(node1.right, node2.left);
		}
	}

}
