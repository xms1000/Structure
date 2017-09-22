package com.xms.examination.wangyi;

import java.util.Arrays;

/**
 * Created by xms on 2017/9/9.
 */
public class ShuLieHuanYuan {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        System.out.println(reverseCount(reverseArray(a)));
    }

    private static int[] reverseArray(int[] a) {
        int i =0;
        int j =a.length-1;
        while (i<j){
            int temp =a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
        return a;
    }

    private static int reverseCount(int[] a) {
        return reverseCount(a,0,a.length-1);
    }

    private static int  reverseCount(int[] a,int low,int high){
        if(low>=high){
            return 0;
        }
        int mid = (low+high)>>>1;
        int l = reverseCount(a,0,mid);
        int r = reverseCount(a,mid+1,high);
        int m = merge(a,low,mid,high);
        return l+r+m;
    }

    private static int merge(int[] a, int low,int mid, int high) {
        int temp=0;
        int[] b =new int[high-low+1];
        int l = mid;
        int r=high;
        int s = high-low;
        while (l>=low&&r>mid){
            if(a[l]>a[r]){
                b[s--]=a[l--];
                temp+=r-mid;
            }else {
                b[s--]=a[r--];
            }
        }
        while (l>=low){
            b[s--]=a[l--];
        }
        while (r>mid){
            b[s--]=a[r--];
        }
        s=0;
        for (int i = low; i <=high ; i++) {
            a[i]=b[s++];
        }
        return temp;
    }
}
