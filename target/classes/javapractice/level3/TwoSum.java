/**
 * 
 */
package java.practice.level3;

import java.util.HashMap;

/**
 * @author Aaron
 * 
 *         Given an array of integers, find two numbers such that they add up to
 *         a specific target number.
 * 
 *         The function twoSum should return indices of the two numbers such
 *         that they add up to the target, where index1 must be less than
 *         index2. Please note that your returned answers (both index1 and
 *         index2) are not zero-based.
 * 
 *         You may assume that each input would have exactly one solution.
 * 
 *         Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        // take care of boundry test cases;
        
        int[] result = {0,0};
        HashMap<Integer, Integer> checker = new HashMap<Integer, Integer>();
        int temp  = 0;
        for(int i = 0; i < numbers.length; i++){
            temp = target - numbers[i];
            if(checker.containsKey(temp)){
                result[0] = Math.min(i, checker.get(temp)) +1;//Whats the so stupid index here
                result[1] = Math.max(i, checker.get(temp)) +1;
                return result;
            }
            checker.put(numbers[i], i);
        }
        return result;
    }
    
    public static void main(String[] str) {
        int[] num = {3,2,0};
            num =   twoSum(num, 6);
        System.out.println(num[0] +":"+ num[1]);
    }
}
