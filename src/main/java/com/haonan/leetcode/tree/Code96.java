package com.haonan.leetcode.tree;

/**
 * @Author rhaonan
 * @Data 2019/10/23
 * @Description 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Code96 {

    public int numTrees(int n) {
        int sum = 0;
        if (n <= 1) {
            return 1;
        }

        for (int i = 1; i <= n; i++) {
            int left = numTrees(i-1);
            int right = numTrees(n-i);
            sum += left*right;
        }
        return sum;
    }

    public static void main(String[] args) {
        Code96 code96 = new Code96();
        System.out.println(code96.numTrees(4));
    }
}
