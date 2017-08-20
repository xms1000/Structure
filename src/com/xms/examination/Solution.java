package com.xms.examination;

import com.xms.examination.status.TreeNode;

import java.io.Serializable;
import java.util.*;

/**
 * Created by xms on 2017/8/19.
 */
public class Solution{
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> dequeue = new LinkedList<>();
        if (pRoot != null) {
            queue.add(pRoot);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            dequeue.add(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] levCount = new int[height(pRoot)];
        levCount(pRoot, 0, levCount);
        for (int i = 0; i < levCount.length; i++) {

            ArrayList<Integer> list = new ArrayList<>();
            if (i % 2 == 0) {
                for (int j = 0; j < levCount[i]; j++) {
                    list.add(dequeue.poll().val);
                }
            } else {
                Stack<Integer> stack = new Stack<>();
                for (int j = 0; j < levCount[i]; j++) {
                        stack.add(dequeue.poll().val);
                }
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
            }
            lists.add(list);
        }

        return lists;

    }

    private void levCount(TreeNode root, int lev, int[] levCount) {
        if (root != null) {
            levCount[lev]++;
            levCount(root.left, lev + 1, levCount);
            levCount(root.right, lev + 1, levCount);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}