package com.xms.offer;

/**
 * Created by xms on 2017/9/12.
 */

import java.io.*;

/**
 * Created by xms on 2017/9/12.
 */
public class ZuiDaQiShuHe {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        long temp = 0;
        for (long i = n; i > 0; i = i / 2) {
            temp += ((i + 1) / 2) * ((i + 1) / 2);
        }
        System.out.println(temp);
    }
}