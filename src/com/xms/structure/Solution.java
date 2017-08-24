package com.xms.structure;

import com.xms.examination.status.TreeNode;

/**
 * Created by xms on 2017/8/19.
 */
public class Solution {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root==null){
            sb.append("#");
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();

    }
    private int index=-1;
    TreeNode Deserialize(String str) {
        index++;
        String[] arr = str.split(",");
        if (index>arr.length){
            return null;
        }
        TreeNode node=null;
        while (!arr[index].equals("#")){
            node = new TreeNode(Integer.parseInt(arr[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }

        return  node;
    }
}