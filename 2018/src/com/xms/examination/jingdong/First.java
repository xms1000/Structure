package com.xms.examination.jingdong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xms on 2017/9/8.
 */
public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] ch = str.toCharArray();
        Stack<Character> s = new Stack<>();
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                s.push(ch[i]);
                count++;
            } else {
                s.pop();
                list.add(count);
                count--;
            }
        }
        int temp = 0;
        int sum = 1;
        for(int x:list){
            temp = x;
            sum *= temp;
        }
        System.out.print(sum);
    }
}
