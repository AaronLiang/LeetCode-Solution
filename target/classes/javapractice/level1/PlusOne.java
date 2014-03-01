/**
 * 
 */
package java.practice.level1;

/**
 * @author aaronl Given a number represented as an array of digits, plus one to
 *         the number.
 * 
 *         Discuss
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits.length < 1) {
			return digits;
		}

		int flag = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
				flag = 1;
			} else {
				digits[i] += flag;
				return digits;
			}
		}
		int[] array = new int[digits.length + 1];
		array[0] = 1;
		return array;
	}
}
