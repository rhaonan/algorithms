package com.haonan.leetcode.tree;

import java.util.*;

/**
 * @Author rhaonan
 * @Data 2019/10/23
 * @Description leetcode199 树的右视图
 */
public class Code199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> depthRightNodeValueMap = new HashMap<>();
        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        treeQueue.add(root);
        depthQueue.add(0);
        while (!treeQueue.isEmpty()) {
            TreeNode tree = treeQueue.remove();
            int depth = depthQueue.remove();
            depthRightNodeValueMap.put(depth, tree.val);
            if (tree.left != null) {
                treeQueue.add(tree.left);
                depthQueue.add(depth+1);
            }
            if (tree.right != null) {
                treeQueue.add(tree.right);
                depthQueue.add(depth+1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : depthRightNodeValueMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
