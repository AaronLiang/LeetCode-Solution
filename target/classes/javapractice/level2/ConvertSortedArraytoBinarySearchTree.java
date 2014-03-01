/**
 * 
 */
package java.practice.level2;

import java.practice.helper.TreeNode;

/**
 * @author aaronl
 * 
 *         Given an array where elements are sorted in ascending order, convert
 *         it to a height balanced BST.
 * 
 *         Discuss
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0) {
			return null;
		}
		int start = 0, end = num.length - 1;
		int mid = (end + start) / 2;
		TreeNode head = new TreeNode(num[mid]);
		head.left = helper(start, mid - 1, num);
		head.right = helper(mid + 1, end, num);
		return head;
	}

	public TreeNode helper(int start, int end, int[] num) {
		if (start > end) {
			return null;
		}
		int mid = (end + start) / 2;
		TreeNode current = new TreeNode(num[mid]);
		current.left = helper(start, mid - 1, num);
		current.right = helper(mid + 1, end, num);
		return current;
	}
}
