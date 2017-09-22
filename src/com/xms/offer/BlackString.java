package com.xms.offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by xms on 2017/9/9.
 */
public class BlackString {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] dp = new int [n+1];
            dp[1] = 3;dp[2]=9;
            for( int i = 3; i <= n; i++ )
                dp[i] = 2*dp[i-1]+dp[i-2];
            System.out.println(dp[n-1]);
        }
    }
}
