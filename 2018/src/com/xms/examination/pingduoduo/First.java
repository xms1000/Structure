package com.xms.examination.pingduoduo;

/**
 * Created by xms on 2017/9/2.
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class First {
    private static TreeMap<Integer,Integer> call(int[] weights,TreeMap<Integer,Integer> map){
        if(weights==null||weights.length==0||map==null){
            return null;
        }
        Arrays.sort(weights);
        boolean[] flag=new boolean[weights.length];
        for(Entry<Integer,Integer> bear:map.entrySet()){
            int fight=bear.getKey();
            int hungry=bear.getValue();
            int i=weights.length-1;
            while(i>=0){
                if(flag[i]==false&&hungry>0&&weights[i]<=hungry){
                    hungry-=weights[i];
                    map.put(fight, hungry);
                    flag[i]=true;
                }
                i--;
            }
        }
        return map;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){

            int n = in.nextInt();
            int m = in.nextInt();
            int[] weights = new int[m];
            for (int i = 0; i < weights.length; i++) {
                weights[i] = in.nextInt();
            }
            int[] temp = new int[n];
            TreeMap<Integer, Integer> map = new TreeMap<>(
                    new Comparator<Integer>() {
                        public int compare(Integer o1, Integer o2) {
                            return o2.compareTo(o1);
                        }
                    });
            for (int i = 0; i < n; i++) {
                int fight = in.nextInt();
                temp[i] = fight;
                map.put(fight, in.nextInt());
            }
            TreeMap<Integer, Integer> result = call(weights, map);
            for (int i = 0; i < temp.length; i++) {
                System.out.println(result.get(temp[i]));
            }
        }
    }
}
