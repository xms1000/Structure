package com.xms.examination.alibaba;

import java.util.Scanner;

/**
 * Created by xms on 2017/8/25.
 */
public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int temp = 0;
            temp += d / a;
            int g = temp, h = temp;
            while (g >= b || h >= c) {
                if (g >= b) {
                    int x = g / b;
                    g = g % b + x;
                    h += x;
                    temp += x;
                }
                if (h >= c) {
                    int y = h / c;
                    h = h % c + y;
                    g += y;
                    temp += y;
                }
            }
            System.out.println(temp);
        }
    }
}
