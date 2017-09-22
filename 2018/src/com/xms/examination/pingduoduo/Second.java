package com.xms.examination.pingduoduo;

import java.util.*;

/**
 * Created by xms on 2017/9/2.
 */
class Node{
    String name;
    TreeSet<String> set;

    public Node(String name, TreeSet<String> set) {
        this.name = name;
        this.set = set;
    }
}
public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<Integer,TreeSet<String>> map = new TreeMap<>();
        TreeSet<String> set;
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] arr = new String[n];
            int k=in.nextInt();
            String str = in.next();
            Node head = new Node(str,new TreeSet<String>());
            arr[0]=str;
            for (int i = 1; i < n; i++) {
                str =in.next();
                k=in.nextInt();
                if(arr[k]!=null){

                }
                if(!map.containsKey(k)){
                    set = new TreeSet<>();
                    set.add(str);
                    map.put(k,set);
                }else {
                    set= map.get(k);
                    set.add(str);
                    map.put(k,set);
                }
            }
            for(int x:map.keySet()){
                set = map.get(x);
                for (String s:set){
                    System.out.println(s);
                }
            }
        }
        in.close();
    }
}