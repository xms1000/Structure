package com.xms.examination.alibaba;

/**
 * Created by xms on 2017/9/7.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int r = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = a[i]/r;
            }
            Arrays.sort(b);
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = b[n-i-1];
            }
            System.out.print(A(c,0,m));
        }
    }
    public static int A(int[] a,int begin,int m){
        int sum=0;
        for (int i = begin; i < a.length; i++) {
            sum += a[i];
        }
        int avg = sum/m;
        if(a[begin] <= avg){
            return avg;
        }else{
            while(a[begin] > avg){
                begin++;
                m--;
            }
            return A(a,begin,m);
        }
    }
}
