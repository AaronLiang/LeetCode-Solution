/**
 * 
 */
package java.practice.level4;

import java.practice.helper.ListNode;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/reorder-list/
 * 
 * @author Aaron
 * 
 *         Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 *         L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 *         You must do this in-place without altering the nodes' values.
 * 
 *         For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        fast = reverse(fast);

        // ListNode p1 = head;// this works
        // ListNode p2 = fast;

        // //merge two lists here
        // while (p2 != null) {
        // ListNode temp1 = p1.next;
        // ListNode temp2 = p2.next;

        // p1.next = p2;
        // p2.next = temp1;

        // p1 = temp1;
        // p2 = temp2;
        // }

        slow = head.next;// this works
        ListNode temp = head;
        while (slow != null && fast != null) {
            temp.next = fast;
            fast = fast.next;
            temp = temp.next;

            temp.next = slow;
            slow = slow.next;
            temp = temp.next;
        }

        // if(slow == null){ //this part is redundant
        // temp.next = fast;
        // }else{
        // temp.next = slow;
        // }
        // if(temp.next != null){
        // temp.next.next = null;
        // }
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        head.next = null;// Trick: Set head node's next
        return pre;
    }
}
