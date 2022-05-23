package com.bee.datastruct.linklist;

/**
 * 链表节点，代表链表中的一个节点。通常链表用头结点表示
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/5/16 11:18
 */
public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode(T val, ListNode<T> next){
        this.val = val;
        this.next = next;
    }

    public ListNode(){}

    public ListNode(T val){
        this.val = val;
    }
}
