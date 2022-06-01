package com.bee.datastruct.tree;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/5/16 18:11
 */
public class SuccessorLCCI {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //找到P节点
        if(root.val > p.val){//如果P是在ROOT左子树，则next是父节点
            if(root.left == null){
                return null;
            }
            root = root.left;
        }else{// 如果P是ROOT或者在ROOT右子树，则next是右子树中的最左节点
            if(root.val == p.val){
                 return findLeftest(root.right);
            }
        }

        return null;
    }

    private TreeNode findLeftest(TreeNode root){
        return null;
    }
}