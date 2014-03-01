/**
 * 
 */
package java.practice.level1;

import java.practice.helper.ListNode;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/add-two-numbers/
 * 
 * @author Aaron
 * 
 *         You are given two linked lists representing two non-negative numbers.
 *         The digits are stored in reverse order and each of their nodes
 *         contain a single digit. Add the two numbers and return it as a linked
 *         list.
 * 
 *         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 *         Discuss
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            temp.next = new ListNode(sum);
            temp = temp.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }

        return head.next;
    }
}
