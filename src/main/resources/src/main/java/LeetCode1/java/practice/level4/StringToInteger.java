/**
 * 
 */
package java.practice.level4;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/string-to-integer-atoi/
 * 
 * @author Aaron
 * 
 * 
 *         Implement atoi to convert a string to an integer.
 * 
 *         Hint: Carefully consider all possible input cases. If you want a
 *         challenge, please do not see below and ask yourself what are the
 *         possible input cases.
 * 
 *         Notes: It is intended for this problem to be specified vaguely (ie,
 *         no given input specs). You are responsible to gather all the input
 *         requirements up front.
 * 
 *         spoilers alert... click to show requirements for atoi.
 * 
 *         Requirements for atoi: The function first discards as many whitespace
 *         characters as necessary until the first non-whitespace character is
 *         found. Then, starting from this character, takes an optional initial
 *         plus or minus sign followed by as many numerical digits as possible,
 *         and interprets them as a numerical value.
 * 
 *         The string can contain additional characters after those that form
 *         the integral number, which are ignored and have no effect on the
 *         behavior of this function.
 * 
 *         If the first sequence of non-whitespace characters in str is not a
 *         valid integral number, or if no such sequence exists because either
 *         str is empty or it contains only whitespace characters, no conversion
 *         is performed.
 * 
 *         If no valid conversion could be performed, a zero value is returned.
 *         If the correct value is out of the range of representable values,
 *         INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
    public int atoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();// Trick1: trim the white spaces
        int sign = 1;
        int start = 0;
        if (str.charAt(0) == '-') {// Trick2: take care about the sign
            sign = -1;
            start = 1;
        } else if (str.charAt(0) == '+') {
            sign = 1;
            start = 1;
        }
        int sum = 0;
        int temp = Integer.MAX_VALUE / 10;
        while (start < str.length() && sum >= 0) {// Trick3: if sum < 0, means
                                                  // its out of the range
            int ch = str.charAt(start) - '0';
            if (ch > 9 || ch < 0) {// Trick4: validate the numbers
                break;
            }
            if (sum > temp) {// Trick5: check the num is in the integer range or
                             // not
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum = sum * 10 + ch;

            start++;
        }

        if (sum < 0) {// Trick7: validate the range;
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sum * sign;
    }
}
