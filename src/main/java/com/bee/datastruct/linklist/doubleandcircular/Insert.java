package com.bee.datastruct.linklist.doubleandcircular;

/**
 * 剑指 Offer II 029. 排序的循环链表:https://leetcode.cn/problems/4ueAj6/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/24
 * <p>
 * [3,4,1]
 * 2
 **/

public class Insert {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if (head == null) {
            head = insert;
            head.next = head;
        } else if (head.next == head) {
            head.next = insert;
            insert.next = head;
        } else {
            insertCore(head, insert);
        }

        return head;
    }

    private void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;

        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if (cur.val >= biggest.val) {
                biggest = cur;
            }

            if (cur.val <= node.val && next.val >= node.val) {
                cur.next = node;
                node.next = next;
            } else {
                node.next = biggest.next;
                biggest.next = node;
            }
        }
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
