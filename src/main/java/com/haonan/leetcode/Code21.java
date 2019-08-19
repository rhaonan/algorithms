package com.haonan.leetcode;

/**
 * @Author rhaonan
 * @Data 2019/7/25
 * @Description leetcode 21 合并两个有序链表
 */
public class Code21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        merge(head, l1, l2);
        return head.next;
    }

    private void merge(ListNode head, ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                ListNode p = l2.next;
                l2.next = null;
                merge(head.next, l1, p);
            } else {
                head.next = l1;
                ListNode p = l1.next;
                l1.next = null;
                merge(head.next, p, l2);
            }
        }
        if (l1 != null && l2 == null) {
            head.next = l1;
        }
        if (l1 == null && l2 != null) {
            head.next = l2;
        }
    }
}
