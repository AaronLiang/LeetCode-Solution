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
 *         Design an algorithm to find the maximum profit. You may complete as
 *         many transactions as you like (ie, buy one and sell one share of the
 *         stock multiple times). However, you may not engage in multiple
 *         transactions at the same time (ie, you must sell the stock before you
 *         buy again).
 * 
 *         Discuss
 */
public class BestTimeToBuyAndSellStock_II {

	/**
	 * 
	 */
	public BestTimeToBuyAndSellStock_II() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit2(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit = profit + prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	public int maxProfit1(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit = profit + prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}

		boolean hasStock = false;
		if (prices[0] < prices[1]) {
			// hasStock = true;
		}
		int profit = 0;
		int buyPrice = prices[0];
		int sellPrice = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (hasStock == false) {
				if (buyPrice > prices[i]) {
					buyPrice = prices[i];
				} else {
					hasStock = true;
					sellPrice = prices[i];
				}
			} else {
				if (sellPrice < prices[i]) {
					sellPrice = prices[i];
				} else {
					profit += (sellPrice - buyPrice);
					hasStock = false;
					buyPrice = prices[i];
					sellPrice = prices[i];
				}

			}
		}
		if (hasStock == true)
			return profit + sellPrice - buyPrice;
		else
			return profit;

	}

}
