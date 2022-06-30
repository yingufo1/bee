package com.bee.others;

/**
 * 715. Range 模块:https://leetcode.cn/problems/range-module/
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0 2022/6/20 16:22
 */
public class RangeModule {
    Node head;

    public RangeModule() {
        head = new Node();
    }

    public void addRange(int left, int right) {
        Node smallOne = querySmallestNode(left);

        if (smallOne == head) {// left比所有区间都大
            smallOne.next = new Node(left, right);
            return;
        }

        if (smallOne.right > left && smallOne.right > right) {
            // do nothing
        }else if (smallOne.right > left && smallOne.right < right) {// left在smallOne区间内，right不在smallOne区间内
            Node cur = smallOne;
            while (cur.next != null && cur.next.left < right) {// 找到right超过的最后一个区间
                cur = cur.next;
            }
            smallOne.right = Math.max(right, cur.right);
            smallOne.next = cur.next;
        }else if (smallOne.right < left && smallOne.right < right) {// left不在smallOne区间内
            Node cur = smallOne;
            while (cur.next != null && cur.next.left < right) {// 找到right超过的最后一个区间
                cur = cur.next;
            }
            smallOne.right = Math.max(right, cur.right);
            smallOne.next = cur.next;
        }
    }

    public boolean queryRange(int left, int right) {
        Node cur = querySmallestNode(left);
        return cur != null && cur.right > left && cur.right > right;
    }

    private Node querySmallestNode(int left) {
        Node cur = head;
        while (cur.next != null && left < cur.next.left) {
            cur = cur.next;
        }
        return cur;
    }

    public void removeRange(int left, int right) {
        Node smallThanLeftOne = querySmallestNode(left);
        Node smallThanRightOne = querySmallestNode(right);

        if (smallThanLeftOne != null) {
            smallThanLeftOne.next = smallThanRightOne == null ? null : smallThanRightOne.next;
        }
    }

    public String toString() {
        Node cur = head.next;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append("range[").append(cur.left).append(",").append(cur.right).append("]");
            cur = cur.next;
        }
        return sb.toString();
    }

    class Node {
        private int left;
        private int right;
        public Node next;

        public Node() {

        }

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public Node(int left, int right, Node next) {
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        RangeModule obj = new RangeModule();
        obj.addRange(10, 20);
        System.out.println(obj.toString());
        obj.removeRange(14, 16);
        System.out.println(obj.toString());
        boolean res = obj.queryRange(10, 14);
        System.out.println(res);// except true
        res = obj.queryRange(13, 15);
        System.out.println(res);// except false
        res = obj.queryRange(16, 17);
        System.out.println(res);// except true
    }
}

/**
 * Your RangeModule object will be instantiated and called as such: RangeModule obj = new RangeModule();
 * obj.addRange(left,right); boolean param_2 = obj.queryRange(left,right); obj.removeRange(left,right);
 *
 * 输入 ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"] [[], [10, 20], [14, 16], [10,
 * 14], [13, 15], [16, 17]] 输出 [null, null, null, true, false, true]
 *
 * 解释 RangeModule rangeModule = new RangeModule(); rangeModule.addRange(10, 20); rangeModule.removeRange(14, 16);
 * rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪） rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13,
 * 15) 中像 14, 14.03, 14.17 这样的数字） rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 *
 *
 * solution from leetcode
 *
 *      TreeMap<Integer, Integer> intervals;
 *
 *     public RangeModule() {
 *         intervals = new TreeMap<Integer, Integer>();
 *     }
 *
 *     public void addRange(int left, int right) {
 *         Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
 *         if (entry != intervals.firstEntry()) {
 *             Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
 *             if (start != null && start.getValue() >= right) {
 *                 return;
 *             }
 *             if (start != null && start.getValue() >= left) {
 *                 left = start.getKey();
 *                 intervals.remove(start.getKey());
 *             }
 *         }
 *         while (entry != null && entry.getKey() <= right) {
 *             right = Math.max(right, entry.getValue());
 *             intervals.remove(entry.getKey());
 *             entry = intervals.higherEntry(entry.getKey());
 *         }
 *         intervals.put(left, right);
 *     }
 *
 *     public boolean queryRange(int left, int right) {
 *         Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
 *         if (entry == intervals.firstEntry()) {
 *             return false;
 *         }
 *         entry = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
 *         return entry != null && right <= entry.getValue();
 *     }
 *
 *     public void removeRange(int left, int right) {
 *         Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
 *         if (entry != intervals.firstEntry()) {
 *             Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
 *             if (start != null && start.getValue() >= right) {
 *                 int ri = start.getValue();
 *                 if (start.getKey() == left) {
 *                     intervals.remove(start.getKey());
 *                 } else {
 *                     intervals.put(start.getKey(), left);
 *                 }
 *                 if (right != ri) {
 *                     intervals.put(right, ri);
 *                 }
 *                 return;
 *             } else if (start != null && start.getValue() > left) {
 *                 intervals.put(start.getKey(), left);
 *             }
 *         }
 *         while (entry != null && entry.getKey() < right) {
 *             if (entry.getValue() <= right) {
 *                 intervals.remove(entry.getKey());
 *                 entry = intervals.higherEntry(entry.getKey());
 *             } else {
 *                 intervals.put(right, entry.getValue());
 *                 intervals.remove(entry.getKey());
 *                 break;
 *             }
 *         }
 *     }
 *
 */
