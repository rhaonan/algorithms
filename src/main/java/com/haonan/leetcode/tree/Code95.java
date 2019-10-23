package com.haonan.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author rhaonan
 * @Data 2019/10/23
 * @Description 定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class Code95 {


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
         List<TreeNode> res = new LinkedList<>();
         if (start > end) {
             res.add(null);
             return res;
         }

         for (int i = start; i <= end; i++ ) {
            List<TreeNode> left = generateTrees(start, i-1);
            List<TreeNode> right = generateTrees(i+1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = leftNode;
                    currentNode.right = rightNode;
                    res.add(currentNode);
                }
            }
         }

         return res;
    }

    public static void main(String[] args) {

    }
}
