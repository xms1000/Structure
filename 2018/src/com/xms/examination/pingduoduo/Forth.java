package com.xms.examination.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xms on 2017/9/2.
 */
public class Forth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int mark = 0;
            int temp = 0;
            int[] h = new int[n];
            h[0] = a[0];
            for (int i = 1; i < n; i++) {
                int start = 0;
                int end = mark;
                while (start <= end) {
                    int j = (start + end) >> 1;
                    if (h[j] < a[i]) {
                        start = j + 1;
                    } else {
                        end = j - 1;
                    }
                }
                h[start] = a[i];
                if (start > temp) {
                    temp = start;
                }
                if (start > mark) {
                    mark++;
                }
            }
            if (temp < k - 1) {
                System.out.println(0);
            } else {
                int len = r - l + 1;
                int x = m - k;
                int count =1;
                for (int i = 0; i <= x; i++) {
                    count*=len%10007;
                }
                System.out.println(count%10007);
            }
        }
        in.close();
    }

}
