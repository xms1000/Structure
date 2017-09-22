package com.xms.examination.zhaohangxinyongka;

import java.util.Scanner;

public class Main {
    private static int cur = 0;
    private static int A = 0;
    private static int B = 0;
    private static boolean isA = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        calculate(a);
        if (A > B) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static void calculate(int[] a) {
        if (cur >= a.length)
            return;
        if (isA) {
            A = add(a, A);
            isA = false;
            calculate(a);
        } else {
            B = add(a, B);
            isA = true;
            calculate(a);
        }
    }
    private static int add(int[] a, int x) {
        if (cur + 3 < a.length) {
            if (a[cur] + a[cur + 1] < a[cur + 3]) {
                x += a[cur++];
            } else {
                x += a[cur++] + a[cur++];
            }
        } else if (cur + 1 < a.length) {
            x += a[cur++] + a[cur++];
        } else if (cur < a.length) {
            x += a[cur++];
        }
        return x;
    }
}
