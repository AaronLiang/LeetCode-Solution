/**
 * 
 */
package java.practice.level1;

import java.practice.helper.TreeNode;
import java.util.ArrayList;

/**
 * @author aaronl
 *
 */

// Given a binary tree, return the inorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,3,2].
//
// Note: Recursive solution is trivial, could you do it iteratively?
//
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized
// on OJ.
//
//
// OJ's Binary Tree Serialization:
// The serialization of a binary tree follows a level order traversal, where '#'
// signifies a path terminator where no node exists below.
//
//Here's an example:
//   1
//  / \
// 2   3
//    /
//   4
//    \
//     5
//The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".


public class BinaryTreeInorderTraversal {

	/**
	 * 
	 */
	public BinaryTreeInorderTraversal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		helper(root, result);
		return result;
	}

	public void helper(TreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}

}
