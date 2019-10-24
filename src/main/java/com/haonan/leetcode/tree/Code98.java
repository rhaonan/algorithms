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

    // 递归判断上界和下界，不能近判断孩子节点，否则只是局部二叉搜索树
    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }

        if(!helper(root.right, root.val, upper)) {
            return false;
        }
        if (!helper(root.left, lower, root.val)) {
            return false;
        }
        return true;
    }

}
