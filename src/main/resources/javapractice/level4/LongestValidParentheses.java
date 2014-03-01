/**
 * 
 */
package java.practice.level4;

import java.util.Stack;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/longest-valid-parentheses/
 * 
 * @author Aaron
 * 
 *         Given a string containing just the characters '(' and ')', find the
 *         length of the longest valid (well-formed) parentheses substring.
 * 
 *         For "(()", the longest valid parentheses substring is "()", which has
 *         length = 2.
 * 
 *         Another example is ")()())", where the longest valid parentheses
 *         substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        // Trick1:deal with invalid brackets that reset counter, starts from 0
        // if start from -1, them line 32 left = i and
        // line38: maxLength = Math.max(maxLength, i - left +1 )
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i + 1;
                    // Trick2: here has a invalid ),this will be
                    // one before the pos of next
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - left + 1);
                        // Trick3: after invalid ) some bracket index offset
                    } else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                        // Trick4: deal with yet to process ( here
                    }
                }
            }
        }
        return maxLength;
    }
}
