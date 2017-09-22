package com.xms.examination.yuanjin;

import java.util.Scanner;

/**
 * Created by xms on 2017/8/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            int l = in.nextInt();
            str = str.substring(0,l);
            System.out.println(str);
        }
    }
}
