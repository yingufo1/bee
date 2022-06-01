package com.bee.datastruct.linklist.reverse;

/**
 * 剑指 Offer II 027. 回文链表:
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/23
 **/

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int reverseStart = len % 2 == 0 ? len / 2 : len / 2 + 1;
        cur = head;
        for (int i = 0; i <= len; i++) {
            cur = cur.next;
        }

        ListNode reverse = reverse(cur);
        cur = head;
        while (cur != null && reverse != null) {
            if (cur.val != reverse.val) {
                return false;
            }
            cur = cur.next;
            reverse = reverse.next;
        }
        return cur == null && reverse == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
