/**
 * 
 */
package java.practice.level4;

import java.practice.helper.ListNode;
import java.util.ArrayList;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 
 * @author Aaron
 * 
 *         Merge k sorted linked lists and return it as one sorted list. Analyze
 *         and describe its complexity.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        ListNode dummp = new ListNode(0);
        ListNode head = dummp;
        while (lists.size() > 1) {
            ListNode temp = lists.get(0);
            if (temp == null) {
                lists.remove(temp);
                continue;
            }// Trick: skip empty list
            for (int i = 1; i < lists.size(); i++) {
                ListNode node = lists.get(i);
                if (node == null) {
                    continue;
                }// Trick: skip empty list
                if (temp.val > node.val) {
                    temp = node;
                }
            }
            head.next = temp;
            head = head.next;
            lists.remove(temp);
            temp = temp.next;
            if (temp != null) {
                lists.add(temp);
            }
        }
        if (lists.size() == 1) {
            head.next = lists.get(0);
        }// Trick: if only one linked list
        return dummp.next;
    }
}
