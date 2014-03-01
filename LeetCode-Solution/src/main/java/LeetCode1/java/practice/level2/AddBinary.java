/**
 * 
 */
package java.practice.level2;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/add-binary/
 * 
 * @author Aaron Given two binary strings, return their sum (also a binary
 *         string).
 * 
 *         For example, a = "11" b = "1" Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        } else if (b == null || b.length() == 0) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int k = 0;
        int la = a.length() - 1;
        int lb = b.length() - 1;

        while (k <= la || k <= lb) {
            int sum = carry;
            if (k <= la) {
                sum += a.charAt(la - k) - '0';
            }

            if (k <= lb) {
                sum += b.charAt(lb - k) - '0';
            }

            if (sum == 0) {
                sb.append("0");
                carry = 0;
            } else if (sum == 1) {
                sb.append("1");
                carry = 0;
            } else if (sum == 2) {
                sb.append("0");
                carry = 1;
            } else if (sum == 3) {
                sb.append("1");
                carry = 1;
            }
            k++;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
