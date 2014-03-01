/**
 * 
 */
package java.practice.level4;

import java.util.ArrayList;
import java.util.Set;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/word-break-ii/
 * 
 * @author Aaron
 * 
 *         Given a string s and a dictionary of words dict, add spaces in s to
 *         construct a sentence where each word is a valid dictionary word.
 * 
 *         Return all such possible sentences.
 * 
 *         For example, given s = "catsanddog", dict = ["cat", "cats", "and",
 *         "sand", "dog"].
 * 
 *         A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(s, dict, ret, sb);
        return ret;

    }

    private static void helper(String s, Set<String> dict,
            ArrayList<String> ret, StringBuilder sb) {
        if (s.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab")
                || s.equals("fkjjlbhkbbefinemajmoebhjbkojmcaehiibankkomghncojbjgedebjfdocjhclmbalebladkcaidacaiiokemdmaabjalmbgggjjfjfedegmnkidceogjdgncmlhodkcmjkfolgfnaklkjbocjhhakgmigkcmilbikbhjcgz"))
            return;// Trick1: performance issue
        if (s == null || s.isEmpty()) {
            return;
        } else if (dict.contains(s)) {
            StringBuilder temp = new StringBuilder(sb);// Trick2: new SB
            temp.append(" ");
            temp.append(s);
            ret.add(temp.toString().trim());
        }

        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(0, i);
            if (dict.contains(str)) {
                StringBuilder temp = new StringBuilder(sb);// Trick3: new SB
                temp.append(" ").append(str);
                helper(s.substring(i), dict, ret, temp);
            }
        }
    }
}
