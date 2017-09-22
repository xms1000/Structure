package com.xms.examination.toutiao;

import java.util.Scanner;

/**
 * Created by xms on 2017/9/11.
 */
public class ReserveStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int n = in.nextInt();
        System.out.println(reserve(str, n));
    }

    private static String reserve(String str, int n) {
        char[] ch=new char[str.length()];
        int ptr=0;
        for (int i = n; i <str.length(); i++) {
            ch[i-n]=str.charAt(i);
            ptr++;
        }
        for (int i = 0; i < n; i++) {
            ch[i+ptr]=str.charAt(i);
        }
        return new String(ch);

    }
}
