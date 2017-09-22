package com.xms.examination.dji;

import java.util.Scanner;

/**
 * Created by xms on 2017/9/7.
 */
public class First
{
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while (in.hasNext()){

            int H = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int h = in.nextInt();
            int s = in.nextInt();
            double t1 = h / (double)x;
            if (t1 < s) {
                int l = h +(int)Math.round ((x - y) * (s - t1));
                if (l >= H) {
                    System.out.println(H);
                } else {
                    System.out.println(l);
                }
            } else {
                System.out.println(Math.round(s * x));
            }
        }
    }
}
