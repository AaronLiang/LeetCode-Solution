/**
 * 
 */
package java.practice.level2;

import java.practice.helper.ListNode;

/**
 * @author aaronl
 * 
 * 
 *         Merge two sorted linked lists and return it as a new list. The new
 *         list should be made by splicing together the nodes of the first two
 *         lists.
 * 
 *         Discuss
 */
public class MergeTwoSortedLists {

	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode result = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l1 != null)
			head.next = l1;
		else
			head.next = l2;
		return result.next;
	}
    
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode result = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}

		if (l1 != null)
			head.next = l1;
		else
			head.next = l2;

		return result;
	}

}
