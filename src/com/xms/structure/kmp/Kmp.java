package com.xms.structure.kmp;

import java.util.Arrays;

/**
 * Created by xms on 2017/8/31.
 */
public class Kmp {
    public static int[] next(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int k = i - 1;
            while (k > 0 && s.charAt(i - 1) != s.charAt(next[k] - 1)) {
                k = next[k] - 1;
            }
            next[i] = next[k] + 1;
        }
        return next;
    }

    public static int match(String reg, String pram) {
        int[] next = next(pram);
        int i = 0, j = 0;
        while (i < reg.length() && j < pram.length()) {
            if (reg.charAt(i) == pram.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j] - 1;
            } else {
                i++;
            }
        }
        return j == pram.length() ? i - j : -1;
    }

    public static void main(String[] args) {
        System.out.println(match("aabcxmsababc", "xms"));
    }
}
