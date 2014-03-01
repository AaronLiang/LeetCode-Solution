/**
 * 
 */
package java.practice.level1;

import java.practice.helper.ListNode;

/**
 * @author aaronl
 * 
 */

// Given a sorted linked list, delete all duplicates such that each element
// appear only once.
//
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.
public class RemoveDuplicatesfromSortedList {

	/**
	 * 
	 */
	public RemoveDuplicatesfromSortedList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode temp = null; // in return, must be initialize
		temp = head;
		while (temp != null && temp.next != null) {
			if (temp.val == temp.next.val) {
				temp.next = temp.next.next;
				continue;// MUST, because {1,1,1} will have a bug, I need to
							// check multiple duplicate
			}
			temp = temp.next;
		}
		return head;
	}
	
	public ListNode deleteDuplicates_1(ListNode head) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    if(head==null) return head;
	    ListNode prev=head;
	    ListNode cur=head.next;

	    while(cur!=null){
	        if(cur.val!=prev.val) prev=prev.next;
	        cur=cur.next;
	        prev.next=cur;
	    }
	    return head;
	}

}
