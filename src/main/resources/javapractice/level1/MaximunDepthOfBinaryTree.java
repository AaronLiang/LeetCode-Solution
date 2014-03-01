/**
 * 
 */
package java.practice.level1;

import java.practice.helper.TreeNode;

/**
 * @author aaronl
 * 
 *         Given a binary tree, find its maximum depth.
 * 
 *         The maximum depth is the number of nodes along the longest path from
 *         the root node down to the farthest leaf node.
 */

///**
// * Definition for binary tree
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */


public class MaximunDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
       return Math.max(maxDepth(root.left), maxDepth(root.right) ) +1 ;
        //remember +1
    }

}
