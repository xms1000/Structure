package com.xms.examination.shunfeng;

import java.util.Scanner;

/**
 * Created by xms on 2017/9/20.
 */
public class Second {
    public static void main(String[] args) {
        int m = (int) (Math.pow(2, 6) - 2);
        System.out.println(m);
        for (int i = 1; i <= m; i++) {
            printLuckNumber(i);
        }
    }

    private static void printLuckNumber(int m) {
        int k = (int) Math.ceil(Math.log((double) (m + 2)) / Math.log((double) 2));
        int index = (int) (m - (Math.pow(2, k - 1) - 1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            sb.append((index & 0x1) == 1 ? '7' : '4');
            index >>>= 1;
        }
        String result = sb.reverse().toString();
        System.out.printf(result + " ");
        if (!result.contains("4")) {
            System.out.println();
        }
    }
}
