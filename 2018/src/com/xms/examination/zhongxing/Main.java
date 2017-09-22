package com.xms.examination.zhongxing;

import java.util.Scanner;

/**
 * Created by xms on 2017/8/31.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in .nextInt();
            int k = in.nextInt();
            int[][] a = new int[k][];
            for (int i = 0; i < k; i++) {
                String[] arr = in.nextLine().split(" ");
                int[] b = new int[arr.length];
                for (int j = 0; j < arr.length; j++) {
                    b[i]=Integer.valueOf(arr[i]);
                }
                a[i]=b;
            }
        }
    }
}
