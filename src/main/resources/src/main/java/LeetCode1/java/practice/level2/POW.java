/**
 * 
 */
package java.practice.level2;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         Implement pow(x, n).
 * 
 *         Discuss
 */
public class POW {
	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}

		double half = pow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else if (n > 0) {// handle n < 0
			return half * half * x;
		} else {
			return half * half / x;
		}

	}
}
