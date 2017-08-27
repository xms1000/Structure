package com.xms.examination.utils;

/**
 * Created by xms on 2017/8/24.
 */
public class Utils {
    public static char getChar(int i) {
        if (i >= 0 && i <= 9) {
            return (char) (i + 48);
        } else if (i >= 10 && i <= 35) {
            return (char) (i + 87);
        } else if(i>=36&&i<=61){
            return (char) (i + 29);
        }
        return '\0';
    }

    public static int getValue(char c) {
        String str = String.valueOf(c);
        if (c >= '0' && c <= '9') {
            return c - 48;
        } else if (c >= 'a' && c <= 'z') {
            return c - 87;
        } else if (c >= 'A' && c <= 'Z') {
            return c - 29;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println((int)'a');
    }
}
