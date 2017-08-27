package com.xms.questions;

import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by xms on 2017/8/25.
 */
public class Calculate {
    private static int[] calculate(String str, int i) {
        Deque<String> queue = new LinkedList<>();
        int pre = 0;
        while (i < str.length() && str.charAt(i) != ')') {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                pre = pre * 10 + ch - 48;
            } else if (ch != '(') {
                addNum(queue, pre);
                queue.add(String.valueOf(ch));
                pre = 0;
            } else {
                int[] s = calculate(str, i + 1);
                pre = s[0];
                i = s[1];
            }
            i++;
        }
        addNum(queue, pre);
        return new int[]{getNum(queue), i};
    }

    private static int getNum(Deque<String> queue) {
        int temp = queue.isEmpty() ? 0 : Integer.parseInt(queue.poll());
        while (!queue.isEmpty()) {
            temp = queue.poll().equals("+") ? temp + Integer.parseInt(queue.poll()) : temp - Integer.parseInt(queue.poll());
        }
        return temp;
    }

    private static void addNum(Deque<String> queue, int pre) {
        String str = queue.pollLast();
        if (str != null && (str.equals("*") || str.equals("/"))) {
            int x = Integer.valueOf(queue.pollLast());
            x = str.equals("*") ? x * pre : x / pre;
            queue.add(String.valueOf(x));
        } else {
            boolean flag = str != null && queue.add(str);
            queue.add(String.valueOf(pre));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(calculate(str,0)[0]);
    }
}
