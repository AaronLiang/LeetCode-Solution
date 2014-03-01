/**
 * 
 */
package java.practice.level3;

import java.util.ArrayList;

/**
 * @author aaronl
 * 
 *         Given n pairs of parentheses, write a function to generate all
 *         combinations of well-formed parentheses.
 * 
 *         For example, given n = 3, a solution set is:
 * 
 *         "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder temp = new StringBuilder("(");
		int l = n, r = n;
		helper(temp, result, l - 1, r);
		return result;

	}

	public void helper(StringBuilder temp, ArrayList<String> result, int l,
			int r) {
		if (l == 0 && r == 0) {
			result.add(temp.toString());
			return;
		}

		if (l > 0) {
			StringBuilder sb = new StringBuilder(temp);
			helper(sb.append("("), result, l - 1, r);
		}

		if (r > l) {
			StringBuilder sb = new StringBuilder(temp);
			helper(sb.append(")"), result, l, r - 1);
		}

	}
}
