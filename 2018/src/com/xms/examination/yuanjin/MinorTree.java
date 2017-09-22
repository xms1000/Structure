package com.xms.examination.yuanjin;

import com.xms.examination.status.TreeNode;

/**
 * Created by xms on 2017/8/29.
 */
public class MinorTree {
    public static boolean isMinorTree(TreeNode root){
        if(root==null)return true;
        return compare(root.left,root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if(left==null) return right ==null;
        if(right==null) return false;
        if(left.val==right.val) return true;
        return compare(left.left,right.right)&&compare(left.right,right.left);
    }

    public static void main(String[] args) {
    isMinorTree(null);
}
}
