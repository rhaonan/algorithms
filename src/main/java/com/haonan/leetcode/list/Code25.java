package com.haonan.leetcode.list;

/**
 * @Author rhaonan
 * @Data 2019/12/3
 * @Description
 */
public class Code25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null ) {
            return null;
        }
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
            if (count >= k) {
                break;
            }
        }
        if (count < k) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        for (int i = 0; i < k; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;

        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }

}
