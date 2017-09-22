package com.xms.examination.souhu;

import java.util.Scanner;

/**
 * Created by xms on 2017/9/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int min = getMin(a);
            System.out.println(min);
        }
        in.close();
    }

    private static int getMin(int[] a) {
        int[][] dp =new int[a.length][a.length];
        for (int j = 0; j < a.length; j++) {
            dp[j][j]=a[j];
            for (int i = j-1; i >=0; i--) {
                if(a[i]==a[j]){
                    dp[i][j]=2*a[i]+dp[i+1][j-1];
                }else{
                    dp[i][j]=Math.min(2*a[i]+dp[i+1][j],2*a[j]+dp[i][j-1]);
                }
            }
        }
        return dp[0][a.length-1];
    }
}
