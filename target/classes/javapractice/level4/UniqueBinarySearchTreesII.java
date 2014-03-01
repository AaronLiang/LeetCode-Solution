/**
 * 
 */
package java.practice.level4;

import java.practice.helper.TreeNode;
import java.util.ArrayList;

/**
 * Source: LeetCode
 * 
 * http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 * @author Aaron
 * 
 */
//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//For example,
//Given n = 3, your program should return all 5 unique BST's shown below.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class UniqueBinarySearchTreesII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(0, n - 1);
    }

    private static ArrayList<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);// if there is no left/right child, it will be null
            return result;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = dfs(start, i - 1);
            ArrayList<TreeNode> right = dfs(i + 1, end);
            for (int j = 0; j < left.size(); j++) {// at least there is null,
                                                   // size >= 1
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i + 1);// node from 1 to n, not
                                                        // 0 to n-1
                    root.left = left.get(j);
                    root.right = right.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
