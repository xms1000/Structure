package com.xms.examination.wangyi;

import org.omg.Dynamic.Parameter;

import java.util.Scanner;

/**
 * Created by xms on 2017/8/30.
 */
public class TreasureMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String reg = in.nextLine();
            String pram = in.nextLine();
            int j = 0;
            for (int i = 0; i < pram.length(); i++) {
                boolean flag = false;
                while (j < reg.length()) {
                    if (reg.charAt(j) == pram.charAt(i)) {
                        flag = true;
                        j++;
                        break;
                    }
                    j++;
                }
                if(!flag){
                    System.out.println("No");
                    return;
                }
            }
            System.out.println("Yes");
        }
    }
}
