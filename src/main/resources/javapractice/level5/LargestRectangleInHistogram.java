/**
 * 
 */
package java.practice.level5;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         过不了大集合。。。。。。。wtf
 */
public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] height) {
        // height = new int[40000];
        // for(int k = 0; k < 40000; k ++){
        // height[k] = k;
        // }
        if (height == null || height.length == 0) {
            return 0;
        }
        if (height.length == 1) {
            return height[0];
        }
        int area = 0;

        for (int i = 0; i < height.length; i++) {
            if (i > 1 && height[i] <= height[i - 1]) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            int temp = 0;
            for (int j = i + 1; j < height.length; j++) {
                min = Math.min(min, height[j]);
                temp = min * (j - i + 1);
                area = Math.max(temp, area);
                if (area > min * height.length - j) {
                    break;
                }
            }
        }
        return area;
    }

    public static void main(String[] str) {
        int[] num = { 1, 2 };
        System.out.println(largestRectangleArea(num));

    }
}
