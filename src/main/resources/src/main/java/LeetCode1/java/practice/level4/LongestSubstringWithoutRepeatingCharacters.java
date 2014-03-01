/**
 * 
 */
package java.practice.level4;

import java.util.HashSet;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}

		int count = 0;
		HashSet<Character> duplChecker = new HashSet<Character>();
		char[] ch = s.trim().toCharArray();

		int i = 0;
		while (i < ch.length) {
			int tempCount = 1;
			int j = i + 1;
			duplChecker = new HashSet<Character>();
			duplChecker.add(ch[i]);
			while (j < ch.length) {
				if (duplChecker.add(ch[j])) {
					tempCount++;
				} else {
					i = j - tempCount;// this is improve the performance
					break;
				}
				j++;// WTF Dont forgot the loop variable
			}
			count = count > tempCount ? count : tempCount;
			i++;
		}
		return count;
	}

	public static void main(String[] str) {
		System.out.println("abcd");
	}
}
