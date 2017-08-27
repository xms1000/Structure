package com.xms.offer;

import java.util.Arrays;

/**
 * Created by xms on 2017/8/25.
 */
public class WordRoad {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0]) {
                char[] ch = matrix.clone();
                if (hasPath(ch, rows, cols, str, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPath(char[] ch, int rows, int cols, char[] str, int i, int j) {
        if (j == str.length) {
            return true;
        }
        if (i < 0 || i >= ch.length || j < 0) {
            return false;
        }
        if (ch[i] == str[j]) {
            ch[i] = '\0';
            boolean flag = hasPath(ch, rows, cols, str, i - cols, j + 1) | hasPath(ch, rows, cols, str, i + cols, j + 1);
            if(flag){
                return true;
            }
            if (i % cols == 0) {
                flag = hasPath(ch, rows, cols, str, i + 1, j + 1);
            } else if (i % cols == cols - 1) {
                flag = hasPath(ch, rows, cols, str, i - 1, j + 1);
            } else {
                flag = hasPath(ch, rows, cols, str, i - 1, j + 1) || hasPath(ch, rows, cols, str, i + 1, j + 1);
                ;
            }
            return flag;

        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SLHECCEIDEJFGGFIE".toCharArray()));
    }
}
