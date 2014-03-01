/**
 * 
 */
package java.practice.level1;

import java.practice.helper.TreeNode;

/**
 * @author aaronl
 * 
 *         Given a linked list, determine if it has a cycle in it.
 * 
 *         Follow up: Can you solve it without using extra space?
 */
public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val != q.val) {
			return false;
		} else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

	}
}
