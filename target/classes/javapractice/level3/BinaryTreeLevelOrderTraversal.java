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
public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				result.add(list);
				list = new ArrayList<Integer>();// .clear(); can not use clear
				if (!queue.isEmpty()) {
					queue.offer(null);
					continue;// remember to break
				} else {
					break;
				}
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
