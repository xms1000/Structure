package com.xms.examination.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by xms on 2017/8/28.
 */
public class Kitchen {
    public static void main(String[] args) throws IOException {
        HashSet<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (str!=null){
            String[] arr = str.trim().split(" ");
            set.addAll(Arrays.asList(arr));
            str= br.readLine();
        }
        System.out.println(set.size());
    }
}
