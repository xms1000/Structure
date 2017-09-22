package com.xms.examination.kedaxunfei;

import java.util.*;

/**
 * Created by xms on 2017/9/16.
 */
public class Third {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeMap<String, StringBuilder> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            if (!map.containsKey(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(in.next());
                map.put(str, sb);
            } else {
                StringBuilder sb = map.get(str);
                sb.append(" ");
                sb.append(in.next());
            }
        }
        boolean flag=true;
        for (String s : map.keySet()) {
            StringBuilder sb = map.get(s);
            if (sb.length() > 6) {
                System.out.println(s + " " + sb.toString());
                flag=false;
            }
        }
        if (flag){
            System.out.println("YES");
        }
    }
}