package com.haonan.leetcode.tree;

import java.util.Stack;

/**
 * @Author rhaonan
 * @Data 2019/10/23
 * @Description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class Code98 {

    // 中序遍历节点值逐个递增
    public boolean isValidBST(TreeNode root) {
        double inorder = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val <= inorder) {
                return false;
            }
            inorder = curr.val;
            curr = curr.right;
        }
        return true;
    }

}
