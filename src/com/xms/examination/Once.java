package com.xms.examination;


import org.junit.Test;

/**
 * Created by xms on 2017/8/23.
 */
public class Once
{
    public static void main(String[] args){
        int[] arr ={111,111,132,231,341,222,222,333,333,123,123,345,345};
        int x=0;
        for(int e:arr){
            x^=e;
        }
        int flag = 0;
        for(int e:arr){
            flag^=lastBit(x^e);
        }
        flag = lastBit(flag);
        int a = 0,b=0,c=0;
        int k = 0;
        for(int e:arr){
            if(lastBit(e^x)==flag){
                a^=e;
            }else {
                k^=e;
            }
        }
        flag = lastBit(k);
        for(int e:arr){
            if(e!=a){
                if((e&flag)!=0){
                    b^=e;
                }else {
                    c^=e;
                }
            }
        }
        System.out.println(a+" "+b+" "+c);
    }

    private static int lastBit(int temp) {
        return temp&~(temp-1);
    }

}
