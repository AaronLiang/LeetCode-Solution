/**
 * 
 */
package java.practice.level3;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         There are N gas stations along a circular route, where the amount of
 *         gas at station i is gas[i].
 * 
 *         You have a car with an unlimited gas tank and it costs cost[i] of gas
 *         to travel from station i to its next station (i+1). You begin the
 *         journey with an empty tank at one of the gas stations.
 * 
 *         Return the starting gas station's index if you can travel around the
 *         circuit once, otherwise return -1.
 * 
 *         Note: The solution is guaranteed to be unique.
 * 
 *         先找到最缺油的加油站 maxdiffId（需大于求的 最大值）， 然后从下一个加油站出发就是最优解，但是如果下一个也是缺油的，
 *         就必须往后继续找一个不缺的。Tricky 的地方是如果到了length-1，下一站是0
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null) {
			return -1;
		}
		int length = gas.length;
		if (length == 0) {
			return -1;
		}
		int sum = 0;
		int maxdiff = Integer.MIN_VALUE;
		int maxdiffId = 0;

		for (int i = 0; i < length; i++) {
			sum = sum + gas[i] - cost[i];
			if (maxdiff < cost[i] - gas[i]) {
				if (cost[i] < gas[i]) {
					continue;
				}
				maxdiff = cost[i] - gas[i];
				maxdiffId = i;
			}
		}
		if (sum < 0) {
			return -1;
		}

		int l = length - 1;
		while (l-- >= 0) {
			if (maxdiffId == length - 1) {
				if (gas[0] >= cost[0]) {
					return 0;
				}
				maxdiffId = 0;
			}
			if (gas[maxdiffId + 1] >= cost[maxdiffId + 1]) {
				return maxdiffId + 1;
			}
			maxdiffId++;
		}

		if (maxdiffId == length - 1) {
			return 0;
		}
		return maxdiffId + 1;

	}
}

// 蛮精巧的一道题。最直白的解法就是从每一个点开始，遍历整个环，然后找出最后剩余油量最大的点。这个是O(n^2)的。但是这题明显不会无聊到让做题人写个两层循环这么简单。
//
// 仔细想一下，其实和以前求最大连续子数组和的题很像。
//
// 在任何一个节点，其实我们只关心油的损耗，定义：
//
// diff[i] = gas[i] – cost[i] 0<=i <n
//
// 那么这题包含两个问题：
//
// 1. 能否在环上绕一圈？
//
// 2. 如果能，这个起点在哪里？
//
// 第一个问题，很简单，我对diff数组做个加和就好了，leftGas = ∑diff[i]，
// 如果最后leftGas是正值，那么肯定存在这么一个起始点。如果是负值，那说明，油的损耗大于油的供给，不可能有解。得到第一个问题的答案只需要O(n)。
//
// 对于第二个问题，起点在哪里？
//
// 假设，我们从环上取一个区间[i, j], j>i， 然后对于这个区间的diff加和，定义
//
// sum[i,j] = ∑diff[k] where i<=k<j
//
// 如果sum[i,j]小于0，那么这个起点肯定不会在[i,j]这个区间里，跟第一个问题的原理一样。举个例子，假设i是[0,n]的解，那么我们知道
// 任意sum[k,i-1] (0<=k<i-1)
// 肯定是小于0的，否则解就应该是k。同理，sum[i,n]一定是大于0的，否则，解就不应该是i，而是i和n之间的某个点。所以第二题的答案，其实就是在0到n之间，找到第一个连续子序列（这个子序列的结尾必然是n）大于0的。
//
// 至此，两个问题都可以在一个循环中解决。


//1:  class Solution {
//	   2:  public:
//	   3:      int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
//	   4:          vector<int> diff(gas.size());
//	   5:          for(int i =0; i< gas.size(); ++i)
//	   6:          {
//	   7:              diff[i] = gas[i] - cost[i];
//	   8:          }
//	   9:          
//	  10:          int leftGas=0, sum =0, startnode=0;
//	  11:          for(int i =0; i<gas.size(); ++i)
//	  12:          {
//	  13:              leftGas += diff[i];
//	  14:              sum += diff[i];
//	  15:              if(sum <0) //只要小于0就不可能是解
//	  16:              {
//	  17:                  startnode = i+1;
//	  18:                  sum=0;
//	  19:              }
//	  20:          }
//	  21:          if(leftGas <0)
//	  22:              return -1;
//	  23:          else
//	  24:              return startnode;
//	  25:      }
//	  26:  };
