package com.xms.examination.didi;

import java.util.Stack;

/**
 * Created by xms on 2017/9/3.
 */
public class MinValueStack<T extends Comparable> extends Stack<T> {
    private Stack<T> min = new Stack<>();

    @Override
    public synchronized T pop() {
        min.pop();
        return super.pop();
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty() || min.isEmpty();
    }


    @Override
    public T push(T item) {
        if (min.isEmpty()) {
            min.push(item);
        } else {
            min.push(item.compareTo(min.peek()) <= 0 ? item : min.peek());
        }
        return super.push(item);
    }

    public T getMin() {
        if (!min.isEmpty())
            return min.peek();
        return null;
    }
}

