package com.xms.examination.huawei;

/**
 * Created by xms on 2017/8/23.
 */

import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = sb.indexOf(String.valueOf(c));
                if (index >= 0) {
                    StringBuilder newSb = new StringBuilder(sb);
                    newSb = newSb.deleteCharAt(index);
                    newSb = newSb.append(c);
                    if (sb.toString().compareTo(newSb.toString()) < 0) {
                        sb = newSb;
                    }
                } else {
                    sb = sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}