package com.xms.examination.qihu;

/**
 * Created by xms on 2017/8/26.
 */
import java.util.Scanner;

public class Second {

    public static int method1(int n,int m,int a,int b,int c,int d,int x,int y,int z){
        int money = 0;
        int n_a = n/a;
        int m_b = m/b;
        int ab = (n_a < m_b)?n_a:m_b;   //组合卖的盒数；
        //剩余的不能组合卖的粉笔数
        n = n - a*ab;
        m = m - b*ab;
        int cc = m/c;   //全白粉笔盒数
        int dd = n/d;  //全彩笔盒数

        money = x*ab + y*cc + z*dd;

        return money;
    }
    public static int method2(int n,int m,int a,int b,int c,int d,int x,int y,int z){
        int money = 0;
        int cc = m/c;   //全白粉笔盒数
        int dd = n/d;  //全彩笔盒数
        n = n - d*dd;
        m = m - c*cc;
        int n_a = n/a;
        int m_b = m/b;
        int ab = (n_a < m_b)?n_a:m_b;   //组合卖的盒数；
        money = x*ab + y*cc + z*dd;
        return money;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int res1 = method1(n, m, a, b, c, d, x, y, z);
        int res2 = method2(n, m, a, b, c, d, x, y, z);
        int money = res1 > res2 ? res1:res2;
        System.out.println(money);

    }

}
