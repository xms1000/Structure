package com.xms.examination.toutiao;

/**
 * Created by xms on 2017/9/10.
 */
import java.util.*;

public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] users = new int[q][3];
        for (int i = 0; i < q; i++) {
            users[i][0] = in.nextInt();
            users[i][1] = in.nextInt();
            users[i][2] = in.nextInt();
        }
        int sum;
        for (int i = 0; i < q; i++) {
            sum = 0;
            for (int j = users[i][0]-1; j < users[i][1]; j++) {
                if(users[i][2] == a[j]){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
