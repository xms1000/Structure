package com.xms.examination.lianjia;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by xms on 2017/9/2.
 */
public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int v = in.nextInt();
            Goods[] goods = new Goods[n];
            for (int i = 0; i < n; i++) {
                goods[i] = new Goods(in.nextInt(), in.nextInt(), in.nextInt());
            }
            Arrays.sort(goods, Collections.<Goods>reverseOrder());
            System.out.println(Arrays.toString(goods));
            int temp = 0;
            int rec = v;
            for (int i = 0; i < n; i++) {
                Goods good = goods[i];
                if (good.w < rec) {
                    int k = rec / good.w;
                    k = Math.min(k, good.m);
                    rec = rec - k * good.w;
                    temp += k * good.s;
                }
            }
            System.out.println(temp);
        }
    }
}

class Goods implements Comparable<Goods> {
    public int m;
    public int w;
    public int s;

    public Goods(int m, int w, int s) {
        this.m = m;
        this.w = w;
        this.s = s;
    }

    @Override
    public int compareTo(Goods o) {
        return Double.compare((double) s / (double) w, (double) o.s / (double) o.w);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "m=" + m +
                ", w=" + w +
                ", s=" + s +
                '}';
    }
}
