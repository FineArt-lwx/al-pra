package com.lwx.al.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertSort {

    public static void sort(int[] array) {
//        log.info("原始：{}", Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
//            log.info("将{}赋值给{}位置", temp, j + 1);
//            log.info(Arrays.toString(array));

        }
    }

    public static void main(String[] args) {

    }
}
