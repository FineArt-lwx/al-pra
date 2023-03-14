package com.lwx.al.sort;

import com.lwx.al.util.SwapUtils;

public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    SwapUtils.swap(array, j, j + 1);
                }
            }
        }
    }
}
