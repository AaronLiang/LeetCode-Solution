/**
 * 
 */
package java.practice.level2;

/**
 * Source: LeetCode
 * 
 * @author aaronl
 * 
 *         Palindrome Number Total Accepted: 5850 Total Submissions: 20282 My
 *         Submissions Determine whether an integer is a palindrome. Do this
 *         without extra space.
 * 
 *         click to show spoilers.
 * 
 *         Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 *         If you are thinking of converting the integer to string, note the
 *         restriction of using extra space.
 * 
 *         You could also try reversing an integer. However, if you have solved
 *         the problem "Reverse Integer", you know that the reversed integer
 *         might overflow. How would you handle such case?
 * 
 *         There is a more generic way of solving this problem.
 * 
 */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int y = 1;
		while (x / y >= 10) {
			y *= 10;
		}
		int z = x;
		while (y >= 10) {
			if (x / y != z % 10) {
				return false;
			}
			x = x % y;
			y = y / 10;
			z = z / 10;
		}
		return true;
	}
}
