/**
 * 
 */
package java.practice.level1;

/**
 * @author aaronl
 * 
 * 
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         If you were only permitted to complete at most one transaction (ie,
 *         buy one and sell one share of the stock), design an algorithm to find
 *         the maximum profit.
 * 
 *         Discuss
 */
public class BestTimetoBuyandSellStock {

	public int maxProfit(int[] prices) {
		int length = prices.length;
		int profit = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			}
			max = prices[i] - min;
			profit = profit > max ? profit : max;
		}
		return profit;
	}
}
