package com.xms.structure.status;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xms on 2017/8/24.
 */
public class Main {
    public static void main(String[] args)throws IOException{
        File file=new File("E:\\2.txt");
        if(file.isFile() && file.exists()) {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineTxt = null;
            FixedPriorityQueue<Integer> fpq = new FixedPriorityQueue<>(10);
            int count = 0;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                fpq.add(Integer.parseInt(lineTxt));
            }
            System.out.println(fpq);
        }
    }
}
