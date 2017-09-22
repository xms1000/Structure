package com.xms.examination.qihu;

import java.util.*;

/**
 * Created by xms on 2017/8/26.
 */
public class First {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                for (int j = 0; j < i; j++) {
                    if (a[j] > a[i]) {
                        b[i]++;
                    }
                }
            }
            System.out.println(Arrays.toString(b));
        }

    }
}