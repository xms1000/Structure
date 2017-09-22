package com.xms.offer;

import java.io.*;
import java.util.Random;

/**
 * Created by xms on 2017/8/24.
 */
public class WriteFile {
    public static void main(String[] args){

        try {
            FileOutputStream out = new FileOutputStream(new File("E:\\2.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(out);
            int x= Integer.MAX_VALUE;
            for(int i = 0;i<Integer.MAX_VALUE>>4;i++){
                Random r = new Random(x);
                x= r.nextInt(Integer.MAX_VALUE);
                StringBuilder sb = new StringBuilder();
                sb.append(x);
                sb.append("\n");
                bos.write(sb.toString().getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
