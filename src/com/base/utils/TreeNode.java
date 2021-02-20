package com.base.utils;

/**
 * @Description TreeNode
 * @Author Monster
 * @Date 2020/9/21 14:40
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x){
        this.val = x;
    }

    public static void printNode(TreeNode root){
        if(root != null){
            printNode(root.left);
            System.out.print(root.val + "->");
            printNode(root.right);
        }
    }
}
