package com.xms.examination.yuanjin;

import com.xms.examination.status.TreeNode;

/**
 * Created by xms on 2017/8/28.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compRoot(root.left, root. right);
    }

    private boolean compRoot(TreeNode left, TreeNode right) {
            if(left==null) return right==null;
            if(right==null) return false;
            if(left.val != right.val) return false;
            return (compRoot(left.left, right.right) && compRoot(left.right, right.left));
    }
}