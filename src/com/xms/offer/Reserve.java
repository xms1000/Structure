package com.xms.offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xms on 2017/9/9.
 */
public class Reserve {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] data = str.split(" ");
        System.out.println(rev(rev(Integer.valueOf(data[0]))+rev(Integer.valueOf(data[1]))));
    }
    private static int rev(int n){
        int count = 0;
        while(n!=0){
            count = count*10+n%10;
            n = n/10;
        }
        return count;
    }
}
