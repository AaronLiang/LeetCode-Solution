/**
 * 
 */
package java.practice.level3;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         Implement strStr().
 * 
 *         Returns a pointer to the first occurrence of needle in haystack, or
 *         null if needle is not part of haystack.
 */
public class ImplementStrStr {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null
                || needle.length() > haystack.length()) {
            return null;
        }
        if (haystack.equals(needle) || needle.length() == 0) {
            return haystack;
        }// dont foget this one,
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length()
                    && haystack.charAt(i + j) == needle.charAt(j++)) {
                if (j == needle.length()) {
                    return haystack.substring(i);
                }
            }

        }
        return null;
    }

}
