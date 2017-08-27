package com.xms.examination.didi;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by xms on 2017/8/26.
 */
public class Second
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr = str.split(" ");

        int k  = in.nextInt();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(k, Collections.<Integer>reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        for(int  i =0;i<arr.length;i++){
            int x = Integer.valueOf(arr[i]);
            maxQueue.add(x);
        }

    }
}
