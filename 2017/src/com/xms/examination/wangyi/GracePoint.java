package com.xms.examination.wangyi;

import java.util.Scanner;

/**
 * Created by xms on 2017/8/28.
 */
public class GracePoint {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int x = in .nextInt();
        int r = (int) Math.sqrt(x);

        int temp=0;
        for (int i = -r-1; i <=r+1; i++) {
            double cur =  Math.sqrt(x-Math.pow(i,2));
            int s = (int) cur;
            if(cur-s==0){
                temp+=2;
            }
        }
        if(Math.pow(r,2)==x){
            temp-=2;
        }
        System.out.println(temp);
    }
}
