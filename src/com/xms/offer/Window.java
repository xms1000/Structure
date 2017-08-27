package com.xms.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xms on 2017/8/25.
 */
public class Window {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList();
        if (size > num.length) {
            return list;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        for (int j = size; j < num.length; j++) {
            while (!deque.isEmpty() && num[j] > num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(j);
            if (deque.peekFirst() <= j - size) {
                deque.pollFirst();
            }
        }
        return list;
    }
}

