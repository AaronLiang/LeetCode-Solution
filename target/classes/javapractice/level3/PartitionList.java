/**
 * 
 */
package java.practice.level3;

import java.practice.helper.ListNode;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         Given a linked list and a value x, partition it such that all nodes
 *         less than x come before nodes greater than or equal to x.
 * 
 *         You should preserve the original relative order of the nodes in each
 *         of the two partitions.
 * 
 *         For example, Given 1->4->3->2->5->2 and x = 3, return
 *         1->2->2->4->3->5.
 */
public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode l = new ListNode(0);
		ListNode r = new ListNode(0);
		ListNode c = head;
		head = l;
		ListNode rr = r;

		while (c != null) {
			if (c.val < x) {
				l.next = c;
				l = c;
			} else {
				r.next = c;
				r = c;
			}
			c = c.next;

		}
		r.next = null;
		l.next = rr.next;
		return head.next;

	}
}
