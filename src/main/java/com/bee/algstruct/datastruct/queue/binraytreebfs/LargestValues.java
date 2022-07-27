package com.bee.algstruct.datastruct.queue.binraytreebfs;import com.bee.algstruct.datastruct.tree.TreeNode;import java.util.ArrayDeque;import java.util.ArrayList;import java.util.List;import java.util.Queue;/** * 剑指 Offer II 044. 二叉树每层的最大值:https://leetcode.cn/problems/hPov7L/ * * @author yangying * @version 1.0 * @since 2022/5/25 **/public class LargestValues {    public List<Integer> largestValues(TreeNode root) {        int current = 0;        int next = 0;        List<Integer> ans = new ArrayList<>();        Queue<TreeNode> queue = new ArrayDeque<>();        if (root != null) {            queue.offer(root);            current = 1;        }        int max = Integer.MIN_VALUE;        while (!queue.isEmpty()) {            TreeNode node = queue.poll();            max = Math.max(node.val, max);            current--;            if (node.left != null) {                next++;                queue.offer(node.left);            }            if (node.right != null) {                next++;                queue.offer(node.right);            }            if (current == 0) {                current = next;                ans.add(max);                max = Integer.MIN_VALUE;                next = 0;            }        }        return ans;    }}