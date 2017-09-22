package com.xms.structure.sort;

import java.util.Arrays;

/**
 * Created by xms on 2017/8/19.
 */
public class MergeSort {
    public static int temp = 0;

    public void sort(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int m = (i + j) / 2;
        sort(a, i, m);
        sort(a, m + 1, j);
        merge(a, i, m, j);
    }

    public void sort(int[] a) {
        int size = 1;
        int i, j, m;
        while (size < a.length) {
            i = 0;
            while (i + size < a.length) {
                m = i + size - 1;
                j = m + size;
                if (j == a.length) {
                    j = a.length - 1;
                }
                merge(a, i, m, j);
                i = j + 1;
            }
            size *= 2;
        }
    }

    private void merge(int[] a, int i, int m, int j) {
        int[] b = new int[j - i + 1];
        int s = 0;
        int h = i;
        int k = m + 1;
        while (h <= m && k <= j) {
            if (a[h] <= a[k]) b[s++] = a[h++];
            else b[s++] = a[k++];
        }
        while (h <= m) b[s++] = a[h++];
        while (k <= j) b[s++] = a[k++];
        for (s = 0; i <= j; i++) a[i] = b[s++];
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int a[] = {5, 3, 2, 4, 1, 5, 2};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));

    }
}
