package com.xms.examination.toutiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by xms on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
        HashSet[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            sets[i] = new HashSet<Integer>();
            for (int j = 0; j < num; j++) {
                sets[i].add(in.nextInt());
            }
        }
        HashSet set = new HashSet<>();
        HashSet color = new HashSet<>();
        for (int i = 0; i < n; i++) {
            color.clear();
            for (int j = 0; j < m; j++) {
                for (Object x : sets[(i + j) % n]) {
                    if (color.contains(x)) {
                        set.add(x);
                    }
                    color.add(x);
//                    if(sets[(i+j+1)%n]!=null&&sets[(i+j+1)%n].contains(x)){
//                        set.add(x);
//                        System.out.println(i);
//                        break;
//                    }
                }
            }
        }
        System.out.println(set.size());
    }
}
