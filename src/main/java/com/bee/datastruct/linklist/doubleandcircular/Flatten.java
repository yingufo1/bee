package com.bee.datastruct.linklist.doubleandcircular;

/**
 * TODO:class description
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/24
 **/

public class Flatten {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node cur = node;
        Node last = null;

        while (cur != null) {
            Node next = cur.next;

            //  如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                next = cur.next;
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                if(next!=null){
                    childLast.next = next;
                    next.prev = childLast;
                }
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;
}
