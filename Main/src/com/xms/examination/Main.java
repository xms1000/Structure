package com.xms.examination;

import java.util.*;

/**
 * Created by xms on 2017/8/19.
 */
public class Main
{
    static class Node implements Comparable<Node> {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.x,x);
        }
        @Override
        public String toString() {
            return x + " " + y ;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
        }
        in.close();
    }

    private static long calculate(int[] a, int n, int k, int d) {
        long[][] max = new long[k+1][n+1];
        long[][] min = new long[k+1][n+1];
        long temp = 0;
        for(int i = 1 ;i<= n;i++){
            max[1][i]=min[1][i]=a[i];
            for(int j = 2;j<=k;j++){
                for(int s = i-1;s>0&&i-s<=d;s--){
                    max[j][i] = Math.max(max[j][i],Math.max(max[j-1][s]*a[i],min[j-1][s]*a[i]));
                    min[j][i] = Math.min(min[j][i],Math.min(max[j-1][s]*a[i],min[j-1][s]*a[i]));
                }
                temp=Math.max(temp,max[k][i]);
            }
        }
        return temp;
    }
}
