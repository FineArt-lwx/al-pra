package com.lwx.al.sort;

public class ShellSort {

    public static void sort(int[] array) {

        for (int increment = array.length / 3 + 1; increment >= 1; increment = increment / 3 + 1) {
            // 第一次循环 固定变化increment 接下来就是insert sort 的流程
            for (int j = increment; j < array.length; j += increment) {
                int temp = array[j];
                int k = j - increment;
                while (k >= 0 && temp < array[k]) {
                    array[k + increment] = array[k];
                    k = k - increment;
                }
                array[k + increment] = temp;
            }

        }
    }
}
