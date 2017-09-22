package com.xms.examination.wangyi;

import java.util.Scanner;

/**
 * Created by xms on 2017/8/28.
 */
public class Fibonacci {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        while (in.hasNext()){
            int x = in.nextInt();
            int temp= 0;
            int a= 0;
            int b=1;
            while (temp<x){
                temp=a+b;
                a=b;
                b=temp;
            }
            System.out.println(Math.min(Math.abs(temp-x),Math.abs(a-x)));
        }
    }
}

