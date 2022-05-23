package com.bee.datastruct.linklist.doublepoint;

import com.bee.datastruct.linklist.ListNode;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/23
 **/

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode front = dummy;
        ListNode behind = dummy;
        int move = 0;
        while (front.next!=null){
            if(move<n){
                move++;
            }else{
                 behind = behind.next;
            }
            front = front.next;
        }

        if(behind.next!=null){
            behind.next = behind.next.next;
        }

        return dummy.next;
    }

}
