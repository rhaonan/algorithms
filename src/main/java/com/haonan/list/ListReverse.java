package com.haonan.list;

/**
 * @Author rhaonan
 * @Data 2019/4/29
 */
public class ListReverse {

    /**
     * 方法一：遍历列表节点依次插入头节点之后
     */
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

    /**
     * 方法二：遍历列表依次反转指针指向
     */
    private static Node reverse2(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node rNode;
        Node pnode = head;
        Node qnode = pnode.getNext();
        while (qnode != null) {
            rNode = qnode.getNext();

            //反转pnode和qnode指向
            qnode.setNext(pnode);
            if (pnode == head) {
                pnode.setNext(null);
            }

            pnode = qnode;
            qnode = rNode;
        }

        return pnode;
    }

    /**
     * 方法三：递归反转
     */
    private static Node reverseRecursive(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
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
        head = reverse2(head);
        printList(head);
        head = reverseRecursive(head);
        printList(head);
    }
}
