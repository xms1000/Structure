package com.xms.xiaomi;

import java.io

        .*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean fun(String table, int n) {
        if(table == null || table.length() <2)
            return false;
        char[] c = table.toCharArray();
        int t;
        int i=0;
        int m = 0;
        while(i < c.length){
            t = (int)c[i] - 48;
            if(t == 1){
                i++;
                continue;
            }
            if(t == 0){
                int index = i;
                int count = 0;
                while(index < c.length && c[index]-48 == 0){
                    count++;
                    index++;
                }
                m += (count-1)/2;
                i = index;
            }
        }
        if(m >= n)
            return true;
        return false;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in

        );
        boolean res;

        String _table;
        try {
            _table = in.nextLine();
        } catch (Exception e) {
            _table = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = fun(_table, _n);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
