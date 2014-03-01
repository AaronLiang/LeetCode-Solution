/**
 * 
 */
package java.practice.level3;

import java.util.Arrays;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/3sum-closest/
 * 
 * @author Aaron
 * 
 *         Given an array S of n integers, find three integers in S such that
 *         the sum is closest to a given number, target. Return the sum of the
 *         three integers. You may assume that each input would have exactly one
 *         solution.
 * 
 *         For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *         The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3) {
            return 0;
        }
        Arrays.sort(num);
        int sum = num[0] + num[1] + num[2] - target;
        for (int i = 0; i < num.length; i++) {

            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {// Trick1: It improves the performance a lot!
                                 // Like three sum
                int temp = num[i] + num[start] + num[end] - target;
                if (Math.abs(temp) < Math.abs(sum)) {
                    sum = temp;
                }
                if (temp == 0) {
                    return target;
                } else if (temp < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return sum + target;
    }
}
