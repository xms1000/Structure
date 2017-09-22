package com.xms.examination;

import com.xms.examination.utils.Bitmap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xms on 2017/8/19.
 */
public class Main
{
    public static void main(String[] args){
        Bitmap bitmaps =new Bitmap((int) Math.pow(2,32));
        int[] a = {3,4,2,34,51,43,5,5,2,5,32,5,624,21,5,432,51234,5,523,5,6,234,44223,44223,23,234,1234,213,423,4,24,3124,4,234,4,243,213,24,234};
        for(int i:a){
            bitmaps.set(i);
        }
        for(int i = bitmaps.getSize();i>=0;i--){
            if(bitmaps.get(i)){
                System.out.print(i+" ");
            }
        }
        ConcurrentHashMap<Integer,Integer> x = new ConcurrentHashMap<>();
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
