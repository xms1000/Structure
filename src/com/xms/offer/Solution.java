package com.xms.offer;

/**
 * Created by xms on 2017/8/25.
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    int count = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(15, Collections.reverseOrder());

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            num = maxHeap.poll();
            minHeap.offer(num);
        } else {
            minHeap.offer(num);
            num = minHeap.poll();
            maxHeap.offer(num);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return Double.valueOf(minHeap.peek());
        }
    }
}