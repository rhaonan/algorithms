package com.haonan.leetcode.list;

/**
 * @Author rhaonan
 * @Data 2019/11/7
 * @Description 删除链表的第N个节点
 */
public class Code19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode, q= dummyNode;
        for (int i = 1; i<= n+1; i++) {
            q = q.next;
        }

        while (q != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;
        return dummyNode.next;

    }
}
