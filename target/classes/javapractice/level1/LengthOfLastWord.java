/**
 * 
 */
package java.practice.level1;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         Given a string s consists of upper/lower-case alphabets and empty
 *         space characters ' ', return the length of last word in the string.
 * 
 *         If the last word does not exist, return 0.
 * 
 *         Note: A word is defined as a character sequence consists of non-space
 *         characters only.
 * 
 *         For example, Given s = "Hello World", return 5.
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		if (s == null || "".equals(s.trim())) {
			return 0;
		}

		char[] ch = (s.trim()).toCharArray();

		int n = 0;
		for (int i = ch.length - 1; i >= 0; i--) {
			if (ch[i] == ' ') {
				return n;
			}
			n++;
		}
		return n;

	}
}
