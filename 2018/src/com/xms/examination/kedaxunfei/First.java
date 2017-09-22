package com.xms.examination.kedaxunfei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xms on 2017/9/16.
 */
public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader((System.in)));
        String str = reader.readLine();
        StringBuilder sb =new StringBuilder(str);
        boolean flag = true;
        while (flag){
            flag=false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == 'R' && sb.charAt(i + 1) == 'L') {
                    if(i-1>=0&&sb.charAt(i-1)=='R') {
                        sb.deleteCharAt(i);
                    }else {
                        sb.deleteCharAt(i+1);
                    }
                    flag=true;
                    break;
                }
            }
        }
        System.out.println(sb.length());
    }
}
