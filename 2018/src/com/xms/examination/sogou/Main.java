package com.xms.examination.sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        double[] positions;
        try {
            n = Integer.parseInt(bufReader.readLine());
            positions = new double[n];
            for (int i = 0; i < n; i++) {
                positions[i] = Double.parseDouble(bufReader.readLine());
            }
            double maxValue = 0;
            for (int i = 0; i < n; i++) {
                double value = getMaxDistance(positions, i);
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            System.out.println(convertDoubleToStringInSpecificPrecision(maxValue, 8));
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("input error");
        }
    }

    public static double getMaxDistance(double[] positions, int index) {
        int length = positions.length;
        double oppositePosition = (positions[index] + 180) % 360;
        int position = getPosition(positions, 0, length - 1, oppositePosition);
        if (oppositePosition == positions[position]) {
            return 180d;
        } else {
            double value1 = Math.abs(positions[index] - positions[position]);
            double value2 = Math.abs(positions[index] - positions[position + 1]);
            value1 = value1 > 180 ? (360 - value1) : value1;
            value2 = value2 > 180 ? (360 - value2) : value2;
            return value1 > value2 ? value1 : value2;
        }
    }

    public static int getPosition(double[] positions, int start, int end, double value) {
        int low = start;
        int high = end - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midValue = positions[mid];
            if (midValue > value) {
                high = mid - 1;
            } else if (midValue < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low == 0 ? 0 : (low - 1);

    }

    public static String convertDoubleToStringInSpecificPrecision(double d, int precision) {
        if (precision == 0) {
            return Integer.toString((int) d);
        }

        StringBuilder format = new StringBuilder("0.");
        for (int i = 0; i < precision; i++) {
            format.append("0");
        }
        DecimalFormat decimalFormat = new DecimalFormat(format.toString());
        return decimalFormat.format(d);
    }
}
