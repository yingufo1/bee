package com.bee.datastruct.linklist.doublepoint;

import com.bee.datastruct.linklist.ListNode;

/**
 * 剑指 Offer II 023. 两个链表的第一个重合节点:https://leetcode.cn/problems/3u1WK4/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/23
 * 2
 * [1,9,1,2,4]
 * [3,2,4]
 * 3
 * 1
 **/

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
