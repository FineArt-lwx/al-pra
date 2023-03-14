package com.lwx.al.sort;

import com.lwx.al.util.SwapUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeapSort {

    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        //        log.info("source:{}", Arrays.toString(array));
        for (int i = array.length - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }

//        for (int i = 0; i < array.length; i++) {
//            heapInsert(array, i);
//        }
        //        log.info("heaped:{}", Arrays.toString(array));

        SwapUtils.swap(array, 0, array.length - 1);
        for (int i = array.length - 1; i > 0; i--) {
            heapify(array, 0, i);
            SwapUtils.swap(array, 0, i - 1);
        }
    }

    private static void heapify(int[] array, int index, int heapSize) {
        int current = index;
        int left;
        while ((left = 2 * current + 1) < heapSize) {
            int largestIndex = array[left] > array[current] ? left : current;
            int right = left + 1;
            largestIndex = right < heapSize && array[right] > array[largestIndex] ? right : largestIndex;
            if (largestIndex == current) {
                return;
            }
            SwapUtils.swap(array, current, largestIndex);
            current = largestIndex;
        }

    }

    private static void heapInsert(int[] array, int index) {
        int parent = (index - 1) / 2;
        while (array[index] > array[parent]) {
            SwapUtils.swap(array, index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }

    }

    public static void main(String[] args) {
        sort(new int[]{0, 3, 7});
    }
}
