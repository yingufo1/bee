package com.bee.algstruct.datastruct.linklist.doublepoint;

import com.bee.algstruct.datastruct.linklist.ListNode;

/**
 * 剑指 Offer II 022. 链表中环的入口节点:<a href="https://leetcode.cn/problems/c32eOV/">...</a>
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/23
 **/

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null){
                slow = slow.next;
                if(fast.next == null){
                    return null;
                }else{
                    fast = fast.next.next;
                }

                if(fast == slow){
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
        }
        return null;
    }
}
