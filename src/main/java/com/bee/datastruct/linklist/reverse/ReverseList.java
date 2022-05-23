package com.bee.datastruct.linklist.reverse;

import com.bee.datastruct.linklist.ListNode;

/**
 * 剑指 Offer II 024. 反转链表:https://leetcode.cn/problems/UHnkqh/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/23
 **/

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
