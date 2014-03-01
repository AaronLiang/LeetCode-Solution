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

//Given a binary tree, return the preorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,2,3].
//
//Note: Recursive solution is trivial, could you do it iteratively?

public class BinaryTreePreorderTraversal {
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		helper(root, result);
		return result;
	}

	public void helper(TreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		helper(root.left, result);
		helper(root.right, result);
	}

}
