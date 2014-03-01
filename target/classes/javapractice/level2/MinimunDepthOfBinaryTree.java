/**
 * 
 */
package java.practice.level2;

import java.practice.helper.TreeNode;

/**
 * Source: LeetCode
 * 
 * @author aaronl
 * 
 *         Given a binary tree, find its minimum depth.
 * 
 *         The minimum depth is the number of nodes along the shortest path from
 *         the root node down to the nearest leaf node.
 */
public class MinimunDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftD = minDepth(root.left);
		int rightD = minDepth(root.right);
		if (leftD == 0) {
			return 1 + rightD;
		} else if (rightD == 0) {
			return 1 + leftD;
		}
		return 1 + Math.min(leftD, rightD);
	}
}
