package com.xms.examination.qihu;

import java.util.Scanner;
/**
 * Created by xms on 2017/8/26.
 */
public class First {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] num = new int[n];
            int[] count = new int[n];
            count[0] = 0;
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
                int j = i;
                while (j > 0 && num[j-1]>num[i]) {
                    j--;
                }
                j--;
                if (j >= 0) {
                    count[i] = count[j] + i - j-1;
                } else {
                    count[i] = i;
                }
            }
            for (int i = 0; i < n; i++) {
                if(i==n-1){
                    System.out.print(count[i]);
                }else {

                    System.out.print(count[i]+" ");
                }
            }
        }
    }
}
