package com.lwx.al.sort;

import com.lwx.al.util.SwapUtils;
import com.lwx.al.validator.RandomArrayGenerator;

public class SimpleSwapSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    SwapUtils.swap(array, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        SortTester.performanceTest(1,new RandomArrayGenerator(100000,100000),SimpleSwapSort::sort,
                SimpleSwapSort::sort);
    }
}
