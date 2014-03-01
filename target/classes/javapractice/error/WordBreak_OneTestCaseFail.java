/**
 * 
 */
package LeetCode1.java.practice.error;

import java.util.Set;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/word-break/
 * 
 * @author Aaron
 * 
 *         Given a string s and a dictionary of words dict, determine if s can
 *         be segmented into a space-separated sequence of one or more
 *         dictionary words.
 * 
 *         For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 *         Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak_OneTestCaseFail {
    public boolean wordBreak(String s, Set<String> dict) {

        if (s == null || s.isEmpty() || dict.contains(s)) {
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i))) {
                return wordBreak(s.substring(i), dict);
            }
        }
        return false;

    }

    // DP
    public boolean wordBreak2(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; // set first to be true, why?
        // Because we need initial state

        for (int i = 0; i < s.length(); i++) {
            // should continue from match position
            if (!t[i])
                continue;

            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;
                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }
}
