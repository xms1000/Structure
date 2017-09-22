package com.xms.examination.jingdong;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.*;

/**
 * Created by xms on 2017/9/8.
 */
public class Second {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        long l = in.nextInt();
        long r = in.nextInt();
        int temp = 0;
        for (long i = l; i <= r; i++) {
            if (isIns(i)) {
                temp++;
            }
        }
        System.out.println(temp);
    }

    private static boolean isIns(long n) {
        List<Integer> list = new ArrayList<Integer>();
        int temp = 0;
        while (n != 0) {
            int x = (int) (n % 10);
            list.add(x);
            temp += x;
            n = n / 10;
        }
        int k = (int) n;
        temp += k;
        list.add(k);
        if (list.size() < 2 || temp % 2 != 0) {
            return false;
        } else {
            int x = temp / 2;
            Collections.sort(list);
            int i = 0;
            int j = 1;
            int cur = list.get(i);
            while (i < list.size() && j < list.size()) {
                if (cur == x) {
                    return true;
                } else if (cur < x) {
                    cur += list.get(j);
                    j++;
                } else {
                    cur -= list.get(i);
                    i++;
                }
            }
        }
        return false;
    }
}
