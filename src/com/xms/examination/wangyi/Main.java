package com.xms.examination.wangyi;

import java.util.*;
public class Main{
    static int n;
    static int m;
    static int[][] data;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            n = scan.nextInt();
            m = scan.nextInt();
            data = new int[n+1][m+1];
            for(int i=1;i<=n;i++){
                String str = scan.next();
                char[] strchar = str.toCharArray();
                for(int j=1;j<=m;j++){
                    data[i][j] = strchar[j-1]-'0';
                }
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    data[i][j]=data[i-1][j]+data[i][j-1]-data[i-1][j-1]+data[i][j];
                }
            }
            int l = 0;
            int r = data[n][m];
            int mid = r = (l+r)>>3;
            int res = 0;
            while(l<=r){
                mid = (l+r)>>1;
                if(check(mid)){
                    l = mid+1;
                    res = mid;
                }else{
                    r = mid-1;
                }
            }
            System.out.println(res);
        }
    }
    private static boolean check(int mid) {
        for(int i=1;i<=n-3;i++){
            for(int j=i+1;j<=n-2;j++){
                for(int k = j+1;k<=n-1;k++){

                    int last = 0;
                    int count = 0;
                    for(int h = 1;h<=m;h++){
                        int sum1 = getSum(0,i,last,h);
                        int sum2 = getSum(i,j,last,h);
                        int sum3 = getSum(j,k,last,h);
                        int sum4 = getSum(k,n,last,h);
                        if(mid<=sum1&&mid<=sum2&&mid<=sum3&&mid<=sum4){
                            last = h;
                            count++;
                        }
                    }
                    if(count>=4){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static int getSum(int startx, int x, int starty, int y) {
        return data[x][y]-data[startx][y]-data[x][starty]+data[startx][starty];
    }
}
