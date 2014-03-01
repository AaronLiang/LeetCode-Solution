/**
 * 
 */
package java.practice.level1;

import java.practice.helper.ListNode;

/**
 * @author aaronl Given a linked list, determine if it has a cycle in it.
 * 
 *         Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycle {

	// /**
	// * Definition for singly-linked list.
	// * class ListNode {
	// * int val;
	// * ListNode next;
	// * ListNode(int x) {
	// * val = x;
	// * next = null;
	// * }
	// * }
	// */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean hasCycle(ListNode head) {
        if(head == null ){
            return false;
        }
        
        ListNode l1 = head, l2 = head;
        while(l2.next != null && l2.next.next != null){ // double check null
            l1 = l1.next;
            l2 = l2.next.next;
            if(l1 == l2){
                return true;
            }
        }
        return false;
    }

}
