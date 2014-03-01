/**
 * 
 */
package java.practice.level2;

import java.practice.helper.ListNode;

/**
 * @author aaronl Given a linked list, remove the nth node from the end of list
 *         and return its head.
 * 
 *         For example,
 * 
 *         Given linked list: 1->2->3->4->5, and n = 2.
 * 
 *         After removing the second node from the end, the linked list becomes
 *         1->2->3->5. Note: Given n will always be valid. Try to do this in one
 *         pass.
 */
public class RemoveNthNodeFromEndofList {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 1) {
			return head;
		}
		ListNode p = head, q = head;
		while (p != null && n > 0) {
			p = p.next;
			n--;
		}

		if (p == null) {
			return head.next;
		}
		p = p.next;
		while (p != null) {
			p = p.next;
			q = q.next;
		}

		q.next = q.next.next;
		return head;
	}
}
