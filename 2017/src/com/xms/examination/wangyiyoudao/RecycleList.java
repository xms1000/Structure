package com.xms.examination.wangyiyoudao;

import java.util.Scanner;

/**
 * Created by xms on 2017/9/7.
 */
public class RecycleList
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int i = 0;
            int j = n-1;
            while (i!=j){
                if(a[i]==a[j]){
                    i++;
                    j--;
                }
            }
        }
    }
}
