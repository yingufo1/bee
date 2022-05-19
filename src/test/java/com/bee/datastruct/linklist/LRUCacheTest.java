package com.bee.datastruct.linklist;


import org.junit.Test;

/**
 * LRUCacheTest
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/5/16 17:32
 */
class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache<Integer> lruCache = new LRUCache<>(5);
        lruCache.put(1);
        lruCache.put(1);
        System.out.println(lruCache.size);
        lruCache.put(2);
        lruCache.put(3);
        lruCache.put(4);
        lruCache.put(5);
        System.out.println(lruCache.size);
        System.out.println(lruCache);
        lruCache.put(4);
        System.out.println(lruCache);
        lruCache.put(105);
        System.out.println(lruCache);
        lruCache.put(3);
        System.out.println(lruCache);
    }
}