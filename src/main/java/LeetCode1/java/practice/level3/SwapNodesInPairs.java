/**
 * 
 */
package java.practice.level3;

import java.practice.helper.ListNode;

/**
 * @author aaronl
 * 
 * 
 *         Given a linked list, swap every two adjacent nodes and return its
 *         head.
 * 
 *         For example, Given 1->2->3->4, you should return the list as
 *         2->1->4->3.
 * 
 *         Your algorithm should use only constant space. You may not modify the
 *         values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) { // care ||
			return head;
		}
		ListNode result = new ListNode(0);
		result.next = head;
		head = result;
		ListNode f, c, b;
		while (head != null && head.next != null && head.next.next != null) { // care &&
			f = head.next;
			c = f.next;
			b = c.next;

			head.next = c;
			c.next = f;
			f.next = b;
			head = f;
		}
		return result.next;
	}
}
