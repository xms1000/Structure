package com.xms.examination.lianjia;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by xms on 2017/9/2.
 */
public class Third {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int day = 1;
        int maxValue = 0;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (i != j) {
                if (a[i] < a[j]) {
                    maxValue += day * a[i];
                    i++;
                } else if (a[i] == a[j]) {
                    int x = i;
                    int y = j;
                    int l = 0;
                    int r = 0;
                    while (x <= y) {
                        l += a[x++];
                        r += a[y--];
                    }
                    if (l < r) {
                        maxValue += day * a[i++];
                    } else {
                        maxValue += day * a[j--];
                    }
                } else {
                    maxValue += day * a[j--];
                }
            } else {
                maxValue += day * a[i++];
            }
            day++;
        }
        System.out.println(maxValue);
    }
}
