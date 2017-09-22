package com.xms.leetcode;

import java.util.Arrays;

/**
 * Created by xms on 2017/9/14.
 */
public class Quick {
    public static void main(String[] args) {
        int[] b = new int[]{101,45, 35, 44, 9, 7, 70, 44, 88, 71, 54, 45, 33, 55, 16, 21, 42, 35, 91, 78};
        quickSort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && a[i] <= a[j])
                j--;
            swap(a, i, j);
            while (i < j && a[i] <= a[j])
                i++;
            swap(a, i, j);
        }
        quickSort(a, low, i - 1);
        quickSort(a, i + 1, high);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
