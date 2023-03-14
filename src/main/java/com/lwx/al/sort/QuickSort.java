package com.lwx.al.sort;

import com.lwx.al.util.SwapUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSort {

    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
//        log.info("source:{}", Arrays.toString(array));
        internalProcess(array, 0, array.length - 1);
    }

    public static void sort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        internalProcess2(array, 0, array.length - 1);
    }

    public static void internalProcess(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition2(array, left, right);
        internalProcess(array, left, mid - 1);
        internalProcess(array, mid + 1, right);

    }

    public static void internalProcess2(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] mids = netherLands(array, left, right);
        internalProcess(array, left, mids[0] - 1);
        internalProcess(array, mids[1] + 1, right);

    }

    private static int partition(int[] array, int left, int right) {
        int l = left - 1;
        int p = left;
        while (p < right) {
            if (array[p] < array[right]) {
                SwapUtils.swap(array, p, ++l);
            }
            p++;

        }
        SwapUtils.swap(array, right, l + 1);
        return l + 1;
    }

    private static int partition2(int[] array, int left, int right) {
        int l = left - 1;
        int p = left;
        int partitionIndex = left + (int) (Math.random() * (right - left));
        SwapUtils.swap(array, partitionIndex, right);
        while (p < right) {
            if (array[p] < array[right]) {
                SwapUtils.swap(array, p, ++l);
            }
            p++;

        }
        SwapUtils.swap(array, right, l + 1);
        return l + 1;
    }

    private static int[] netherLands(int[] array, int left, int right) {
        int l = left - 1;
        int r = right;
        int p = left;
        int partitionIndex = left + (int) (Math.random() * (right - left));
        SwapUtils.swap(array, partitionIndex, right);
        while (p < r) {
            if (array[p] < array[right]) {
                SwapUtils.swap(array, p, ++l);
                p++;
            } else if (array[p] > array[right]) {
                SwapUtils.swap(array, p, --r);
            } else {
                p++;
            }

        }

        return new int[]{l + 1, r - 1};

    }

}
