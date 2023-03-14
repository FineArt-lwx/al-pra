package com.lwx.al.sort;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeSort {

    public static void sortByRecursion(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        try {
            internalProcess(array, 0, array.length - 1);
        } catch (Error e) {
            log.error("array:{}", Arrays.toString(array), e);
            throw e;
        }
    }

    private static void internalProcess(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        internalProcess(array, left, mid);
        internalProcess(array, mid + 1, right);
        merge(array, left, mid, right);

    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= right) {
            temp[p++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            temp[p++] = array[p1++];
        }
        while (p2 <= right) {
            temp[p++] = array[p2++];
        }
        for (int e : temp) {
            array[left++] = e;
        }

    }
}
