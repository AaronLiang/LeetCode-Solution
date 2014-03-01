/**
 * 
 */
package java.practice.level4;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author Aaron
 * 
 *         Given a string S, find the longest palindromic substring in S. You
 *         may assume that the maximum length of S is 1000, and there exists one
 *         unique longest palindromic substring.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int length = s.length();
        String str = s.substring(0, 1);

        for (int i = 0; i < length - 1; i++) {
            int start = i;
            int end = i + 1;
            while (start >= 0 && end < length
                    && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            if (str.length() < end - start - 1) {// case s--,e++
                str = s.substring(start + 1, end);
            }
            start = i;
            end = i + 2;
            while (start >= 0 && end < length
                    && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            if (str.length() < end - start - 1) {// case s--,e++
                str = s.substring(start + 1, end);// Trick: from start +1 to end
            }
        }
        return str;
    }
}
