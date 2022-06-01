package com.bee.datastruct.linklist;

/**
 * 基于链表实现的LRU缓存
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/5/16 11:21
 */
public class LRUCache<T> {
    private ListNode<T> header;
    private int capacity;
    public int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(T t) {
        if (find(t)) {//已存在元素
            return;
        }

        if (size == capacity) {//超过负载
            //删除链尾
            ListNode<T> cur = header;
            while (cur.next != null && cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            size--;
        }

        //插入链头
        header = new ListNode<>(t, header);
        size++;
    }

    public boolean find(T t) {
        ListNode<T> cur = header;
        if (header == null) {
            return false;
        }

        if (header.val == t) {
            return true;
        }

        while (cur.next != null && cur.next.val != t) {
            cur = cur.next;
        }

        if (cur.next != null) {//已查找到
            ListNode<T> temp = new ListNode<>(cur.next.val, cur.next.next);
            cur.next = cur.next.next;
            temp.next = header;
            header = temp;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> cur = header;
        while (cur != null) {
            sb.append(cur.val).append(",");
            cur = cur.next;
        }
        return sb.toString();
    }
}
