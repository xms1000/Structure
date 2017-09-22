package com.xms.examination.wangyi;

import java.util.Arrays;

/**
 * Created by xms on 2017/8/31.
 */
public class InversePairs {
    public static int InversePairs(int [] array) {
        return inverse(array,0,array.length-1);
    }
    public static int inverse(int[] a, int low, int high) {
        if (low == high) {
            return 0;
        }
        int inverse = 0;
        int mid = (low + high) >> 1;
        int left= inverse(a, low, mid);
        int right = inverse(a, mid + 1, high);
        int count = merge(a, low, mid, high);
        return (left+right+count)%1000000007;
    }

    private static int merge(int[] a, int low, int mid, int high) {
        int[] b = new int[high - low + 1];
        int temp=0;
        int i = mid;
        int j = high;
        int s = high-low;
        while (i >= low && j >mid) {
            if (a[i] > a[j]) {
                temp+=j-mid;
                b[s--] = a[i--];
                if (temp>=1000000007){
                    temp%=1000000007;
                }
            } else {
                b[s--]=a[j--];
            }
        }
        while (i>=low){
            b[s--]=a[i--];
        }
        while (j>mid){
            b[s--]=a[j--];
        }
        for(int x :b){
            a[low++]=x;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(InversePairs(a));
    }

}
