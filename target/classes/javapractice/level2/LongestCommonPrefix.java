/**
 * 
 */
package java.practice.level2;

/**
 * Source: LeetCode http://oj.leetcode.com/problems/longest-common-prefix/
 * 
 * @author Aaron
 * 
 *         Write a function to find the longest common prefix string amongst an
 *         array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int min = strs[0].length();
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
            for (int j = 0; j < min; j++) {
                if (str.charAt(j) != strs[i].charAt(j)) {
                    min = j;
                    break;
                }
            }
            if (min == 0) {
                return "";
            }
        }

        return str.substring(0, min);

    }

}
