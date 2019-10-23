package com.haonan.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author rhaonan
 * @Data 2019/5/7
 * @Description 二叉树遍历算法
 */
public class BinTreeTraverse {

    /**
     * 前序遍历
     */
    private static void preOrderTraverse(Tree root) {
        if (root != null) {
            System.out.println(root.getValue());
            preOrderTraverse(root.getLeft());
            preOrderTraverse(root.getRight());
        }
    }

    /**
     * 中序遍历
     */
    private static void inOrderTraverse(Tree root) {
        if (root != null) {
            inOrderTraverse(root.getLeft());
            System.out.println(root.getValue());
            inOrderTraverse(root.getRight());
        }
    }

    /**
     * 后序遍历
     */
    private static void postOrderTraverse(Tree root) {
        if (root != null) {
            postOrderTraverse(root.getLeft());
            postOrderTraverse(root.getRight());
            System.out.println(root.getValue());
        }
    }

    /**
     * 层次遍历-广度优先搜索
     */
    private static void levelTraverse(Tree root) {
        if (root == null) {
            return;
        }
        LinkedList<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            System.out.println(node.getValue());
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    /**
     * 深度优先搜索 遍历
     */
    private static void depthSearch(Tree root) {
        if (root == null) {
            return;
        }
        Stack<Tree> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            System.out.println(node.value);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
    }

    private static class Tree {
        private int value;
        private Tree left;
        private Tree right;

        private Tree (int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        private int getValue() {
            return value;
        }

        private Tree getLeft() {
            return left;
        }

        private Tree getRight() {
            return right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public void setRight(Tree right) {
            this.right = right;
        }
    }

    private static Tree createBinTree( ) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LinkedList<Tree> list = new LinkedList<>();
        for (int value : values) {
            Tree tree = new Tree(value);
            list.offer(tree);
        }

        for (int i = 0; i < values.length/2 - 1; i++) {
            list.get(i).setLeft(list.get(2 * i + 1));
            list.get(i).setRight(list.get(2 * i + 2));
        }

        int last = values.length/2 - 1;
        list.get(last).setLeft(list.get(last * 2 + 1));
        if (last * 2 + 2 < values.length) {
            list.get(last).setRight(list.get(last * 2 + 2));
        }

        return list.get(0);
    }


    public static void main(String[] args) {
        Tree root = createBinTree();
        levelTraverse(root);
        System.out.println("------");
        preOrderTraverse(root);
        System.out.println("------");
        inOrderTraverse(root);
        System.out.println("------");
        postOrderTraverse(root);
        System.out.println("------");
        depthSearch(root);
    }

}
