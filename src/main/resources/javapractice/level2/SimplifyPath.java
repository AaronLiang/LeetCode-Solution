/**
 * 
 */
package java.practice.level2;

import java.util.Stack;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/simplify-path/
 * 
 * @author Aaron
 * 
 *         http://leetcodenotes.wordpress.com/2013/10/20/leetcode-permutation-
 *         sequence
 *         -%E7%BB%99%E4%B8%AAn%EF%BC%8Ck%EF%BC%8C%E6%89%BE%E7%AC%ACk%E4%
 *         B8%AAn%E4
 *         %B8%AAdigit%E7%BB%84%E6%88%90%E7%9A%84%E6%95%B0%E5%AD%97%EF%BC
 *         %8C%E5%A6%82123132213/
 */

//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//click to show corner cases.
//
//Corner Cases:
//Did you consider the case where path = "/../"?
//In this case, you should return "/".
//Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//In this case, you should ignore redundant slashes and return "/home/foo".
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "";
        }
        path = path.trim();
        String[] token = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String str : token) {
            if (str.equals(".") || str.isEmpty()) {
                continue;
            }
            if (str.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());// use insert(index, str), can not use
                                      // append
            sb.insert(0, "/");//
        }
        // sb.append("/");// handle case "/"
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
