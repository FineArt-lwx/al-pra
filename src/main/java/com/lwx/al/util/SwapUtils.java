package com.lwx.al.util;

public class SwapUtils {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 使用异或运算交换空间内的值
     */
    public static void swapByXor(int[] array, int i, int j) {
        if (i == j) {
            //同一位置无需交换，不能直接使用下面逻辑，会导致不正确的逻辑
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
