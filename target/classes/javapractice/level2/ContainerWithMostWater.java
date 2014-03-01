/**
 * 
 */
package java.practice.level2;

/**
 * @author aaronl
 * 
 * 
 *         Given n non-negative integers a1, a2, ..., an, where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 *         which together with x-axis forms a container, such that the container
 *         contains the most water.
 * 
 *         Note: You may not slant the container.
 */
public class ContainerWithMostWater {

	public int maxArea1(int[] height) {
		int max = 0;
		int start = 0;
		int end = height.length - 1;

		while (start < end) {
			max = Math.max(max,
					(end - start) * Math.min(height[start], height[end]));
			if (height[start] < height[end]) {
				start++;
			} else {
				end--;
			}

		}
		return max;
	}

	public int maxArea(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			if (max / (height.length - i) > height[i])
				continue;// this will improve performance
			for (int j = i + 1; j < height.length; j++) {
				int tmp = (j - i) * Math.min(height[i], height[j]);
			max = max > tmp ? max : tmp;
			}
		}
		return max;
	}

}
