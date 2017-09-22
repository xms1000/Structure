package com.xms.examination.sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xms on 2017/9/8.
 */
public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(in.readLine());
        double[] row = new double[n];
        for (int i = 0; i < n; i++) {
            row[i] = Double.parseDouble(in.readLine());
        }
        double temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                double x = row[j] - row[i];
                if (x > 180) {
                    x = 360 - x;
                }
                temp = Math.max(temp, x);
            }
        }
        System.out.printf("%10.8f", temp);
    }
}
