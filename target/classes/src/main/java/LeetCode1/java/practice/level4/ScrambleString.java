/**
 * 
 */
package java.practice.level4;

import java.util.Arrays;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/scramble-string/
 * 
 * @author Aaron
 * 
 */
//
//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
//
//Below is one possible representation of s1 = "great":
//
//    great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
//To scramble the string, we may choose any non-leaf node and swap its two children.
//
//For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
//
//    rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
//We say that "rgeat" is a scrambled string of "great".
//
//Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
//
//    rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
//We say that "rgtae" is a scrambled string of "great".
//
//Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s1 == s2;
        } else if (s1.length() == 1 && s2.length() == 1) {
            return s1.equals(s2); // if s1 = s2 they must be scramble
        } else if (s1.length() != s2.length()) {
            return false;
        }

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if (!new String(ch1).equals(new String(ch2))) {
            return false;
        }// Trick1: add this check will pass ETL

        int length = s1.length();
        for (int i = 0; i < length; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            // Trick2: split from beginning
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }

            // Trick3: split from end
            s21 = s2.substring(0, length - i);
            s22 = s2.substring(length - i);

            if (isScramble(s11, s22) && isScramble(s12, s21)) {
                return true;
            }
        }
        return false;
    }
}
