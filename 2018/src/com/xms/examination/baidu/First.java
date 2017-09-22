package com.xms.examination.baidu;

import java.util.Scanner;

/**
 * Created by xms on 2017/9/11.
 */
public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int S = in.nextInt();
        int temp=1;
        for (int i = 1; i <S ; i++) {
            int k=L/i;
            if(k>=i){
                temp+=cap(k,i);
                if (temp>=123456789){
                    temp%=123456789;
                }
            }
        }
        System.out.println(temp);
    }

    private static int cap(int l, int n) {
        if(n==0){
            return 1;
        }else {
            int up=1;
            int down=1;
            for (int i = 1; i <= n; i++) {
                down*=i;
            }
            for (int i=0;i<n;i++){
                up*=(l-i);
            }
            System.out.println(down);
            return up/down;
        }
    }
}
