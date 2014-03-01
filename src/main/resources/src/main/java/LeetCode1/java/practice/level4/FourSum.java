/**
 * 
 */
package java.practice.level4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/4sum/
 * 
 * @author Aaron Given an array S of n integers, are there elements a, b, c, and
 *         d in S such that a + b + c + d = target? Find all unique quadruplets
 *         in the array which gives the sum of target.
 * 
 *         Note: Elements in a quadruplet (a,b,c,d) must be in non-descending
 *         order. (ie, a ≤ b ≤ c ≤ d) The solution set must not contain
 *         duplicate quadruplets. For example, given array S = {1 0 -1 0 -2 2},
 *         and target = 0.
 * 
 *         A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (num == null || num.length < 4) {
            return ret;
        }
        Arrays.sort(num);
        int length = num.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }// Trick: ignore the duplicate
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }// Trick: ignore the duplicate
                int start = j + 1;
                int end = length - 1;
                int temp = target - num[i] - num[j];
                while (start < end) {
                    if (start > j + 1 && num[start] == num[start - 1]) {
                        start++;
                        continue;
                    }// Trick: ignore the duplicate
                    if (end < length - 1 && num[end] == num[end + 1]) {
                        end--;
                        continue;
                    }// Trick: ignore the duplicate

                    if (num[start] + num[end] == temp) {
                        list = new ArrayList<Integer>();// why c
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        ret.add(list);
                        start++;
                        end--;
                    } else if (num[start] + num[end] < temp) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return ret;
    }
}
