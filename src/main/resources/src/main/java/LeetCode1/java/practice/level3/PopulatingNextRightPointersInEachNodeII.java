/**
 * 
 */
package java.practice.level3;

import java.practice.helper.TreeLinkNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-
 * ii/
 * 
 * @author Aaron
 * 
 */

//Follow up for problem "Populating Next Right Pointers in Each Node".
//
//What if the given tree could be any binary tree? Would your previous solution still work?
//
//Note:
//
//You may only use constant extra space.
//For example,
//Given the following binary tree,
//         1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \    \
//    4-> 5 -> 7 -> NULL

///**
// * Definition for binary tree with next pointer.
// * public class TreeLinkNode {
// *     int val;
// *     TreeLinkNode left, right, next;
// *     TreeLinkNode(int x) { val = x; }
// * }
// */

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        q.offer(null);
        TreeLinkNode pre = null;
        while (!q.isEmpty()) {
            TreeLinkNode current = q.poll();
            if (current != null) {// Trick1: when we do level tranverse, put
                                  // left then put right, but this question,
                                  // should put right first
                if (current.right != null) {
                    q.offer(current.right);
                }
                if (current.left != null) {
                    q.offer(current.left);
                }

                current.next = pre;

            } else if (!q.isEmpty()) {
                q.offer(null);
            }
            pre = current;

        }
    }
    
    // perfect binary tree
    public void connect1(TreeLinkNode root) {
        TreeLinkNode node = root;
        if (root == null) {
            return;
        }
        TreeLinkNode head = node.left;
        while (head != null) {
            node.left.next = node.right;
            if (node.next != null) {
                node.right.next = node.next.left;
                node = node.next;
            } else {
                node = head;
                head = node.left;
            }
        }
    }
}
