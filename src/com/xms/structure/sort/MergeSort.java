package com.xms.structure.sort;

import java.util.Arrays;

/**
 * Created by xms on 2017/8/19.
 */
public class MergeSort {
    public static int temp = 0;


    public static void sort(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int m = (i + j) / 2;
        sort(a, i, m);
        sort(a, m + 1, j);
        merge(a, i, m, j);
    }

    public static void merge(int[] a, int i, int m, int j) {
        int[] b = new int[j - i + 1];
        int s = 0;
        int h = i;
        int k = m + 1;
        while (h <= m && k <= j) {
            if (a[i] < a[j]) {
                b[s++] = a[h++];
            } else {
                b[s++] = a[k++];
            }
        }
        while (h <= m) {
            b[s++] = a[h++];
        }
        while (k <= j) {
            b[s++] = a[k++];
        }
        for (s = 0; i <= j; i++) {
            a[i] = b[s++];
        }
    }

}
