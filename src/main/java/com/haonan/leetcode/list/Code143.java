package com.haonan.leetcode.list;

/**
 * @Author rhaonan
 * @Data 2019/10/23
 * @Description leetcode 143 重排链表
 */
public class Code143 {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return ;
        }

        // 找到中间结点 链表拆成两部分
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secHead = slow.next;
        slow.next = null;

        //后半部分链表逆序
        secHead = reverseList(secHead);
        ListNode firHead = head;

        //两个链表交叉合并
        while (secHead != null) {
            ListNode temp = secHead.next;
            secHead.next = firHead.next;
            firHead.next = secHead;
            firHead = secHead.next;
            secHead = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
