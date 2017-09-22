package com.xms.examination.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xms on 2017/9/7.
 */
public class LuckyPackage {
    private static int temp = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            temp = 0;
            Arrays.sort(a);
            calcuate(a, a.length);
            System.out.println(temp);
        }
    }

    private static void calcuate(int[] a, int k) {
        int count =0;
        int cul =1;
        if(k==1){
            return;
        }
        for (int i = 0; i < k; i++) {
            count+=a[i];
            cul*=a[i];
        }
        if(count>cul){
            temp++;
        }


    }
}
