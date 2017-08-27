package com.xms.examination.alibaba;

import java.util.Scanner;

/**
 * Created by xms on 2017/8/25.
 */
public class Second {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            char[][] arr = new char[n][n];
            for(int i =0;i<n;i++){
                arr[i] = in.next().toCharArray();
            }
            int temp =0;
            for (int i = 0; i <n  ; i++) {
                for (int j = 0; j < n; j++) {
                    temp+= call(arr,i,j,n);
                }
            }
            System.out.println(temp);
        }
    }

    private static int call(char[][] arr,int i,int j,int n) {
        if(i<0||i>=n||j<0||j>=n){
            return 0;
        }
        if(arr[i][j]=='*'){
            arr[i][j]='0';
            System.out.println(1);
            call(arr,i-1,j,n);
            call(arr,i-1,j-1,n);
            call(arr,i-1,j+1,n);
            call(arr,i,j-1,n);
            call(arr,i,j+1,n);
            call(arr,i+1,j-1,n);
            call(arr,i+1,j,n);
            call(arr,i+1,j+1,n);
            return 1;
        }
        return  0;
    }
}
