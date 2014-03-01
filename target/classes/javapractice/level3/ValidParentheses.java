/**
 * 
 */
package java.practice.level3;

import java.util.Stack;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         Given a string containing just the characters '(', ')', '{', '}', '['
 *         and ']', determine if the input string is valid.
 * 
 *         The brackets must close in the correct order, "()" and "()[]{}" are
 *         all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')')
                if (stack.isEmpty()) {
                    return false;
                }
            if (ch == '}' && stack.pop() != '{') {
                return false;
            } else if (ch == ']' && stack.pop() != '[') {
                return false;
            } else if (ch == ')' && stack.pop() != '(') {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
