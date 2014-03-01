/**
 * 
 */
package java.practice.level3;

import java.util.Stack;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * @author Aaron
 * 
 */
//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
//Discuss
//

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 1) {
            return 0;
        }
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (!operators.contains(tokens[i])) {
                stack.push(tokens[i]);
            } else if (stack.size() < 2) {
                return -1;// throws exception
            } else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                switch (tokens[i]) {
                case "+":
                    stack.push(String.valueOf(a + b));
                    break;
                case "-":
                    stack.push(String.valueOf(a - b));
                    break;
                case "*":
                    stack.push(String.valueOf(a * b));
                    break;
                case "/":
                    stack.push(String.valueOf(a / b));
                    break;
                default:
                    return -1;// throws exception
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
