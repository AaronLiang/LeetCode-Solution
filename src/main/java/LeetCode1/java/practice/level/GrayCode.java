/**
 * 
 */
package java.practice.level;

import java.util.ArrayList;

/**
 * @author aaronl http://xiaotongchen.me/posts/47
 * 
 * 
 */

// The gray code is a binary numeral system where two successive values differ
// in only one bit.
//
// Given a non-negative integer n representing the total number of bits in the
// code, print the sequence of gray code. A gray code sequence must begin with
// 0.
//
// For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//
// //00 - 0
// //01 - 1
// //11 - 3
// //10 - 2
// Note:
// For a given n, a gray code sequence is not uniquely defined.
//
// For example, [0,2,3,1] is also a valid gray code sequence according to the
// above definition.
//
// For now, the judge is able to judge based on one instance of gray code
// sequence. Sorry about that.



//My idea 
//Let's take a look at the following example:
//
//2            =>          3
//
//00          00          000
//
//01          01          001
//
//11   =>   11    =>  011
//
//10          10          010
//
//             10          110
//
//             11          111
//
//             01          101
//
//             00          100
//
//From the above example we can see the difference between 2 and 3. 
//
//First, 'mirror' the sequence.(the red sequence is mirrored from the original sequence)
//
//Then, add 1 in front of the new codes.(the green digits are added)


public class GrayCode {

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(0);
		int num = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = ans.size() - 1; j >= 0; j--) {
				ans.add(num + ans.get(j));
			}
			num <<= 1;
		}
		return ans;
	}

}
