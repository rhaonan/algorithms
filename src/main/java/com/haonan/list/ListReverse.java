package com.haonan.list;

/**
 * @Author rhaonan
 * @Data 2019/4/29
 */
public class ListReverse {

    private static Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node pNode = head.getNext();
        Node qNode;
        while (pNode.getNext() != null) {
            qNode = pNode.getNext();
            //QNode 插入到头部节点之后
            pNode.setNext(qNode.getNext());
            qNode.setNext(head.getNext());
            head.setNext(qNode);
        }

        pNode.setNext(head);
        head = pNode.getNext().getNext();
        pNode.getNext().setNext(null);
        return head;
    }

    private static class Node {
        private int value;
        private Node next;

        private Node (int value) {
            this.value = value;
            this.next = null;
        }

        private void setNext(Node node) {
            this.next = node;
        }

        private int getValue() {
            return value;
        }

        private Node getNext() {
            return next;
        }
    }

    private static Node createNodeList(int length) {
        Node head = new Node(length);
        if (length > 0) {
            Node next = createNodeList(length - 1);
            head.setNext(next);
        }
        return head;
    }

    private static void printList(Node head) {
        System.out.println("--- start ---");
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
        System.out.println("--- finished ---");
    }

    public static void main(String[] args) {
        Node head = createNodeList(10);
        printList(head);
        head = reverse(head);
        printList(head);
    }
}
