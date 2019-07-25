package com.haonan.list;

/**
 * @Author rhaonan
 * @Data 2019/7/19
 * @Description 合并K个排序链表
 */
public class MergeKList {

    /**
     * 分治法加递归
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length < 1) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }

        ListNode[] p11 = new ListNode[length/2];
        ListNode[] p12 = new ListNode[length/2];

        System.arraycopy(lists, 0, p11, 0, length/2);
        System.arraycopy(lists, length/2, p12, 0, length/2);

        if (length%2 == 0) {
            return mergeList(p11, p12);
        } else {
            return mergeNode(lists[length-1], mergeList(p11, p12));
        }
    }

    private ListNode mergeList(ListNode[] list1, ListNode[] list2) {
        int len1 = list1.length, len2 = list2.length;
        if (len1 <= 1 && len2 <= 1) {
            return mergeNode(list1[0], list2[0]);
        }

        ListNode[] p11 = new ListNode[len1/2], p12 = new ListNode[len1/2];
        System.arraycopy(list1, 0, p11, 0, len1/2);
        System.arraycopy(list1, len1/2, p12, 0, len1/2);

        ListNode[] p21 = new ListNode[len2/2], p22 = new ListNode[len2/2];
        System.arraycopy(list2, 0, p21, 0, len2/2);
        System.arraycopy(list2, len2/2, p22, 0, len2/2);

        if (len1%2 == 0 && len2%2 == 0) {
            return mergeNode(mergeList(p11, p12), mergeList(p21, p22));
        } else if (len1%2 != 0 && len2%2 != 0) {
            return mergeNode(mergeNode(list1[len1-1], mergeList(p11, p12)), mergeNode(list2[len2-1], mergeList(p21, p22)));
        } else if (len1%2 != 0 && len2%2 == 0) {
            return mergeNode(mergeNode(list1[len1-1], mergeList(p11, p12)), mergeList(p21, p22));
        } else {
            return mergeNode(mergeList(p11, p12), mergeNode(list2[len2-1], mergeList(p21, p22)));
        }
    }

    private ListNode mergeNode(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        merge(head, node1, node2);
        return head.next;
    }

    private void merge(ListNode head, ListNode node1, ListNode node2) {
        if (node1 == null && node2 != null) {
            head.next = node2;
        }
        if (node1 != null && node2 == null) {
            head.next = node1;
        }
        if (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                head.next = node2;
                ListNode p = node2.next;
                node2.next = null;
                merge(head.next, node1, p);
            } else {
                head.next = node1;
                ListNode p = node1.next;
                node1.next = null;
                merge(head.next, node2, p);
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
     }

    public static void main(String[] args) {

    }
}
