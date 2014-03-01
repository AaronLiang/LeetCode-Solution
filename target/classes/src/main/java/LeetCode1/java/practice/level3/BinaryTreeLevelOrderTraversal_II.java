/**
 * 
 */
package java.practice.level3;

import java.practice.helper.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aaronl
 * 
 */

// Given a binary tree, return the bottom-up level order traversal of its nodes'
// values. (ie, from left to right, level by level from leaf to root).
//
// For example:
// Given binary tree {3,9,20,#,#,15,7},
// 3
// / \
// 9 20
// / \
// 15 7
// return its bottom-up level order traversal as:
// [
// [15,7]
// [9,20],
// [3],
// ]
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized
// on OJ.
public class BinaryTreeLevelOrderTraversal_II {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				result.add(0, list);
				list = new ArrayList<Integer>();
				if (!queue.isEmpty())
					queue.offer(null);
				continue;
			}
			list.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return result;
	}
}
