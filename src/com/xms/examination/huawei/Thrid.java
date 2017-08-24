package com.xms.examination.huawei;

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
                l+=getValue(str.charAt(i))*(int) Math.pow(x,str.length()-1-i);
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
                sb.append(getChar(s.pop()));
            }
            System.out.println(sb.toString());
        }
    }

    private static char getChar(int i) {
        if(i>=0&&i<=9){
            return (char) (i+48);
        }else if(i>=10&&i<=35){
            return (char) (i+87);
        }else {
            return (char) (i+29);
        }
    }

    private static int getValue(char c) {
        String str = String.valueOf(c);
        if(c>='0'&&c<='9'){
            return c-48;
        }
        if(c>='a'&&c<='z'){
            return c-87;
        }
        if(c>='A'&&c<='Z'){
            return c-29;
        }
        return -1;
    }
}
