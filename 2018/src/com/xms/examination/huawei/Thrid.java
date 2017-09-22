package com.xms.examination.huawei;

import com.xms.examination.utils.Utils;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by xms on 2017/8/23.
 */
public class Thrid {
    public  static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int x=in.nextInt();
            int y=in.nextInt();
            String str = in.next();
            int l = 0;
            int i=0;
            Boolean flag =false;
            if(str.charAt(0)=='-'){
                flag =true;
            }
            if(flag){
                i=1;
            }
            for(;i<str.length();i++){
                l+=Utils.getValue(str.charAt(i))*(int) Math.pow(x,str.length()-1-i);
            }
            int c=0;
            Stack<Integer> s =new Stack<>();
            while (l!=0){
                c=l%y;
                l=l/y;
                s.add(c);
            }
            StringBuffer sb = new StringBuffer();
            if (flag){
                sb.append("-");
            }
            while (!s.isEmpty()){
                sb.append(Utils.getChar(s.pop()));
            }
            System.out.println(sb.toString());
        }
    }


}
