package com.xms.examination.baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xms on 2017/9/11.
 */
public class Thrid {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        StringBuilder sb = new StringBuilder();
        char[] a = new char[3];
        for (int i = 0; i < str.length(); i++) {
            if(i>=2&&a[i]!=a[i-1]&&a[i]!=a[i-2]&&a[i-1]!=a[i-2]){
                sb.append('C');

            }else {
                switch (str.charAt(i)) {
                    case 'R':
                        sb.append('S');
                        break;
                    case 'B':
                        sb.append('K');
                        break;
                    case 'L':
                        sb.append('H');
                        break;

                }
            }
            a[i % 3] = str.charAt(i);
        }
        System.out.println(sb.toString());
    }
}
