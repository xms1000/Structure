package com.xms.examination.dji;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xms on 2017/9/7.
 */
public class Second {
    private static int[] xd = {1, 0, -1, 0};
    private static int[] yd = {0, 1, 0, -1};
    private static final int INF = 100000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int tom_x = in.nextInt();
            int tom_y = in.nextInt();
            int out_x = in.nextInt();
            int out_y = in.nextInt();
            int[][] a = new int[n][m];
            int[][] distance = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            setArray(a, n, m);
        }
    }
    private static void setArray(int[][] a, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    a[i][j] = -1;
                } else if (a[i][j] == 2) {
                    setValue(a, i - 1, j);
                    setValue(a, i + 1, j);
                    setValue(a, i, j - 1);
                    setValue(a, i, j + 1);
                    a[i][j] = -1;
                } else if (a[i][j] == 3) {
                    setValue(a, i - 1, j);
                    setValue(a, i + 1, j);
                    setValue(a, i, j - 1);
                    setValue(a, i, j + 1);
                    setValue(a, i - 2, j);
                    setValue(a, i + 2, j);
                    setValue(a, i, j - 2);
                    setValue(a, i, j + 2);
                    a[i][j] = -1;
                }
            }
        }
    }

    private static void setValue(int[][] a, int i, int j) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length) {
            return;
        }
        a[i][j] = a[i][j] == 0 ? -1 : a[i][j];
    }


    public class MazeCell {
        private int x;
        private int y;
        private int step;

        public MazeCell(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }
    }
}
