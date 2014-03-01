/**
 * 
 */
package java.practice.level3;

import java.practice.helper.ListNode;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * @author Aaron
 * 
 *         Given a sorted linked list, delete all nodes that have duplicate
 *         numbers, leaving only distinct numbers from the original list.
 * 
 *         For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given
 *         1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        ListNode temp = result;
        boolean flag = true;
        while (head.next != null) {
            if (head.val != head.next.val) {
                if (flag) {
                    temp.next = head;
                    temp = temp.next;
                }
                flag = true;
            } else {
                flag = false;
            }
            head = head.next;
        }

        if (flag) {// Trick1: flag = true, mean the last one is not duplicate
            if (head.next == null) {
                temp.next = head;
            }
        }else {
            temp.next = null;
        }
        return result.next;
    }
}
