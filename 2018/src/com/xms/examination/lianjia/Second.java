package com.xms.examination.lianjia;

import java.util.Scanner;

/**
 * Created by xms on 2017/9/2.
 */
public class Second {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        for (int i = 0; i < l; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            count = 0;
            call(0, n - 1, 0, m, m);
            System.out.println(count);
        }
    }

    private static void call(int x1, int x2, int x3, int x4, int x5) {
        if (x3 > x4) {
            return;
        }
        for (int i = x5; i >= 0; i--) {
            if (x1 == x2 && x3 + i == x4) {
                count++;
            } else if (x1 < x2) {
                call(x1 + 1, x2, x3 + i, x4, i);
            }
        }
    }
}
