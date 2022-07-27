package com.bee.algstruct.datastruct.tree.binarytreedfs;import com.bee.algstruct.datastruct.tree.TreeNode;/** * 剑指 Offer II 048. 序列化与反序列化二叉树：https://leetcode.cn/problems/h54YBf/ * * @author yangying * @version 1.0 * @since 2022/5/26 **/public class Codec {    // Encodes a tree to a single string.    public String serialize(TreeNode root) {        if (root == null) {            return "#";        }        String left = serialize(root.left);        String right = serialize(root.right);        return root.val + "," + left + "," + right;    }    // Decodes your encoded data to tree.    public TreeNode deserialize(String data) {         String[] str = data.split(",");         int[] i = {0};         return dfs(str,i);    }    private TreeNode dfs(String[] str,int[] i){        String s = str[i[0]];        i[0]++;        if(s.equals("#")){            return null;        }        TreeNode left = dfs(str,i);        TreeNode right = dfs(str,i);        return new TreeNode(Integer.parseInt(s),left,right);    }}// Your Codec object will be instantiated and called as such:// Codec ser = new Codec();// Codec deser = new Codec();// TreeNode ans = deser.deserialize(ser.serialize(root));