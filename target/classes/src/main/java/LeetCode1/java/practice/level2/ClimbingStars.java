/**
 * 
 */
package java.practice.level2;

/**
 * @author aaronl
 * 
 * 
 *         You are climbing a stair case. It takes n steps to reach to the top.
 * 
 *         Each time you can either climb 1 or 2 steps. In how many distinct
 *         ways can you climb to the top?
 * 
 *         Discuss
 */
public class ClimbingStars {

	
	public int climbStairs1(int n) {
		if (n <= 3) {
			return n;
		}
		int cache = climbStairs(n - 2);
		return climbStairs(n - 3) + 2 * cache;

	}
	
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		// int cache = climbStairs(n-2);
		// return climbStairs(n-1) + cache;
		int[] sum = new int[n + 1];
		sum[0] = 0;
		sum[1] = 1;
		sum[2] = 2;
		for (int i = 3; i <= n; i++) {
			sum[i] = sum[i - 1] + sum[i - 2];
		}
		return sum[n];
	}

}
