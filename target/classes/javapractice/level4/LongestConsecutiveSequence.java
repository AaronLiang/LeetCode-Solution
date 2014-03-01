/**
 * 
 */
package java.practice.level4;

import java.util.HashSet;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/longest-consecutive-sequence/
 * 
 * @author Aaron
 * 
 *         Given an unsorted array of integers, find the length of the longest
 *         consecutive elements sequence.
 * 
 *         For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
 *         elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 *         Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        int length = num.length;
        if (length < 2) {
            return length;
        }
        int l = 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < length; i++) {
            set.add(num[i]);
        }

        for (int i = 0; i < length && !set.isEmpty(); i++) {
            int n = num[i];
            set.remove(n);
            int temp = 1;
            int j = 1;
            boolean b1 = true, b2 = true;
            while (i + j < length && (b1 || b2)) {
                if (set.contains(n - j) && b1) {
                    temp++;
                    set.remove(n - j);
                    b1 = true;
                } else {
                    b1 = false;
                }
                if (i + j < length && set.contains(n + j) && b2) {
                    temp++;
                    set.remove(n + j);
                    b2 = true;
                } else {
                    b2 = false;
                }
                j++;
            }
            l = l > temp ? l : temp;
        }

        return l;
    }
}
