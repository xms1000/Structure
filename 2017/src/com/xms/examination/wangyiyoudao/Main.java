package com.xms.examination.wangyiyoudao;

/**
 * Created by xms on 2017/9/7.
 */

import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    public static int deal(int m, int n) {//m到n
        int mark[] = new int[n + 1];//记录到达每一个位置的步数
        for (int i = m + 1; i <= n; i++) { //初始化
            mark[i] = Integer.MAX_VALUE;
        }
        for (int i = m; i < n - 1; i++) { //填mark[]
            if (mark[i] == Integer.MAX_VALUE) continue; //如果当前起始位置本身不可达 不作处理
            ArrayList<Integer> list = allFactor(i); //获得当前位置i的所有因子
            for (int j = 0; j < list.size(); j++) { //计算i能到达的每一个位置tmp
                int tmp = i + list.get(j);
                int count = mark[i] + 1;
                if (tmp <= n && mark[tmp] > count) { //如果从i到达位置tmp的次数比以前记录的小 更新mark[tmp]
                    mark[tmp] = count;
                }
            }
        }
        return mark[n];
    }

    public static ArrayList<Integer> allFactor(int n) {//获得n的所有因子 除1 n外
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) list.add(n / i);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = deal(m, n);
        if (r == Integer.MAX_VALUE) r = -1;
        System.out.println(r);
    }
}