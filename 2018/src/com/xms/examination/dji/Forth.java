package com.xms.examination.dji;

import java.util.Scanner;

/**
 * Created by xms on 2017/9/13.
 */
public class Forth {
    public static void main(String[] args) {
        int[] a = {1, 3, 3, 5, 7, 9};
        System.out.println(divide(a, 3));
    }

    public static int divide(int[] a, int k) {
        int start = 0;
        int end = a.length - 1;
        int mid=0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (a[mid] == k) {
                return a[mid];
            } else if (a[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return a[end];
    }
}
