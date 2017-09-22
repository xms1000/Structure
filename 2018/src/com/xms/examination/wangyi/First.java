package com.xms.examination.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xms on 2017/9/9.
 */
public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] ch = str.toCharArray();
        char pre = ch[0];
        int sum = 1;
        int count = 0;
        int temp = 1;
        int i = 1;
        for (; i < ch.length; i++) {
            if (ch[i] == pre) {
                sum++;
            } else {
                temp++;
                count += sum;
                sum = 1;
                pre = ch[i];
            }
        }
        count += sum;
        System.out.printf("%.2f", (double) count / (double) temp);
    }
}
