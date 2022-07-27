package com.bee.algstruct.datastruct.tree.binarysearchtree;import com.bee.algstruct.datastruct.tree.TreeNode;/** * 剑指 Offer II 053. 二叉搜索树中的中序后继:https://leetcode.cn/problems/P5rCT8/ * * @author yangying * @version 1.0 * @since 2022/5/28 **/public class InorderSuccessor {    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {       TreeNode cur = root;       TreeNode result = null;       while (cur != null){           if(cur.val > p.val){               result = cur;               cur = cur.left;           }else{               cur = cur.right;           }       }       return result;    }}