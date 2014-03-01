/**
 * 
 */
package java.practice.level4;

import java.practice.helper.ListNode;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/sort-list/
 * 
 * @author Aaron
 * 
 *         Sort a linked list in O(n log n) time using constant space
 *         complexity.
 * 
 *         Discuss
 */
public class SortList_LinkedList_nlgn {
    // https://github.com/mengli/leetcode/blob/master/SortList.java
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        slow = sortList(head);
        fast = sortList(fast);

        return merge(slow, fast);

    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;
            } else if (l1 != null) {
                head.next = l1;
                break;
            } else {
                head.next = l2;
                break;
            }
        }
        return temp.next;
    }
}
