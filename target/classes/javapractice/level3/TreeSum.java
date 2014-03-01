/**
 * 
 */
package java.practice.level3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/3sum/
 * 
 * @author Aaron
 * 
 *         Given an array S of n integers, are there elements a, b, c in S such
 *         that a + b + c = 0? Find all unique triplets in the array which gives
 *         the sum of zero.
 * 
 *         Note: Elements in a triplet (a,b,c) must be in non-descending order.
 *         (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.
 *         For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *         A solution set is: (-1, 0, 1) (-1, -1, 2)
 */
public class TreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = num.length - 1;
            int sum = 0 - num[i];

            while (start < end) {
                if (num[start] + num[end] == sum) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[start++]);
                    temp.add(num[end--]);
                    result.add(temp);
                    while (start < end && num[start] == num[start - 1])
                        // avoid the duplicates {-1, 0, 0, 1}
                        start++;
                    while (end > start && num[end] == num[end + 1])
                        // avoid the duplicates {-1, 0 , 1, 1}
                        end--;
                } else if (num[start] + num[end] < sum) {
                    start++;
                    while (start < end && num[start] == num[start - 1])
                        // improve the performance
                        start++;
                } else {
                    end--;
                    while (end > start && num[end] == num[end + 1])
                        // improve the performance
                        end--;
                }
            }
        }
        return result;
    }
}
