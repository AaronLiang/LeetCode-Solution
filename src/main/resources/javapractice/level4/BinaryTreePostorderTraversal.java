/**
 * 
 */
package java.practice.level4;

import java.practice.helper.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author aaronl
 * 
 * 
 */

//Given a binary tree, return the postorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [3,2,1].

//Note: Recursive solution is trivial, could you do it iteratively?
public class BinaryTreePostorderTraversal {

	public ArrayList<Integer> postorderTraversal1(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Set<TreeNode> set = new HashSet<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		set.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left == null && node.right == null) {
				result.add(node.val);
				stack.pop();
			} else if (node.left != null && set.add(node.left)) {
				if (true)
					stack.push(node.left);
			} else if (node.right != null && set.add(node.right)) {
				if (true)
					stack.push(node.right);
			} else {
				result.add(node.val);
				stack.pop();
			}
		}
		return result;
	}
    
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		helper(result, root);
		return result;
	}

	public void helper(ArrayList<Integer> result, TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			helper(result, root.left);
		}

		if (root.right != null) {
			helper(result, root.right);
		}
		result.add(root.val);
	}
}
