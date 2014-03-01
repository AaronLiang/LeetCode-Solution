/**
 * 
 */
package java.practice.level1;

import java.practice.helper.ListNode;

/**
 * @author aaronl
 * 
 *         Given a linked list, return the node where the cycle begins. If there
 *         is no cycle, return null.
 * 
 *         Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycle_II {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode l1 = head, l2 = head;
		while (l2.next != null && l2.next.next != null) {
			l1 = l1.next;
			l2 = l2.next.next;
			if (l1 == l2) {
				l2 = head;
				while (true) {
					if (l1 == l2) {
						return l1;
					}
					l1 = l1.next;
					l2 = l2.next;
				}
			}
		}

		return null;
	}
}
