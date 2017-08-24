package com.xms.examination.huawei;

import java.util.Scanner;

/**
 * Created by xms on 2017/8/23.
 */
public class First {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            if(str==null||str.length()==0){
                System.out.println("ERROR!");
                return;
            }
            StringBuffer sb =new StringBuffer();
            for(int i = 0 ;i<str.length();i++){
                char c = str.charAt(i);
                if(!((c>'0'&&c<'9')||(c>'A'&&c<'Z')||(c>'a'&&c<'z'))){
                    sb=new StringBuffer("ERROR!");
                    break;
                }
                if(i%2==0){
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
