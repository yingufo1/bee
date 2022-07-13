package com.bee.algstruct.datastruct.linklist.reverse;

/**
 * 剑指 Offer II 025. 链表中的两数相加:https://leetcode.cn/problems/lMSNwu/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/23
 *
[7,2,4,3]
[5,6,4]
 **/

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode l3 = new ListNode();
        int add = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            if (val >= 10) {
                val = val % 10 + add;
                add = 1;
            } else {
                add = 0;
            }
            l3.next = new ListNode(val);
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        add(l1 !=null?l1:l2,l3,add);

        return reverse(l3.next);
    }

    private void add(ListNode l,ListNode l3,int add){
        while (l != null) {
            int val = l.val + add;
            if (val >= 10) {
                val = val % 10 + add;
                add = 1;
            } else {
                add = 0;
            }
            l = l.next;
            l3.next = new ListNode(val);
            l3 = l3.next;
        }
        if(add>0){
            l3.next = new ListNode(add);
        }
    }

    private ListNode reverse(ListNode head) {
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
