package com.xms.structure.status;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xms on 2017/8/24.
 */
public class FixedPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {
    int max;
    public FixedPriorityQueue(int max){
        super(max);
        this.max = max;
    }
    public  FixedPriorityQueue(int max, Comparator<T> comparator){
        super(max,comparator);
        this.max=max;
    }

    @Override
    public boolean add(T t) {
        if(size()<max){
            return super.add(t);
        }
        if(peek().compareTo(t)<0){
            poll();
            return super.add(t);
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Boolean flag = false;
        for(T t:c){
            flag = add(t);
        }
        return flag;
    }
}
