package com.bee.algstruct.datastruct.linklist.reverse;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 026. 重排链表:https://leetcode.cn/problems/LGjMqU/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/23
 **/

public class ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
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
