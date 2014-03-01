/**
 * 
 */
package java.practice.level4;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/valid-palindrome/
 * 
 * @author Aaron
 * 
 *         Given a string, determine if it is a palindrome, considering only
 *         alphanumeric characters and ignoring cases.
 * 
 *         For example, "A man, a plan, a canal: Panama" is a palindrome.
 *         "race a car" is not a palindrome.
 * 
 *         Note: Have you consider that the string might be empty? This is a
 *         good question to ask during an interview.
 * 
 *         For the purpose of this problem, we define empty string as valid
 *         palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty() || s.trim().length() < 2) {
            return true;
        }

        s = s.trim();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (!isChar(s.charAt(start)) && start < end) {
                ++start;
            }

            while (!isChar(s.charAt(end)) && start < end) {
                --end;
            }

            if (s.charAt(start) != s.charAt(end)
                    && !areEqual(s.charAt(start), s.charAt(end))) {
                return false;// Trick1: use &&, how to compare uppercase and
                             // lowercase
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean areEqual(char ch1, char ch2) {
        if (ch1 == ch2 || (ch1 > '9' && ch2 > '9' && Math.abs(ch1 - ch2) == 32)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isChar(char ch) {
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')
                || (ch >= '0' && ch <= '9')) {
            return true;
        } else {
            return false;
        }
    }
}
