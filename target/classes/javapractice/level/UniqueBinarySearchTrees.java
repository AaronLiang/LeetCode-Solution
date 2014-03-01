/**
 * 
 */
package java.practice.level;

/**
 * @author aaronl
 * 
 */

// Given n, how many structurally unique BST's (binary search trees) that store
// values 1...n?
//
// For example,
//Given n = 3, there are a total of 5 unique BST's.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class UniqueBinarySearchTrees {

	/**
	 * 
	 */

	// Count[3] = Count[0]*Count[2] (1为根的情况)
	// + Count[1]*Count[1] (2为根的情况)
	// + Count[2]*Count[0] (3为根的情况)

	// 所以，由此观察，可以得出Count的递推公式为
	// Count[i] = ∑ Count[0...k] * [ k+1....i] 0<=k<i-1

	public int numTrees(int n) {
		if (n < 2) {
			return 1;
		}

		int[] num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				num[i] += num[j] * num[i - j - 1];
			}
		}
		return num[n];
	}

	public UniqueBinarySearchTrees() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
