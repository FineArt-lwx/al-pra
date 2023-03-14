package com.lwx.al.sort;

import java.util.Arrays;

public class SimpleSort {

    //简单交换排序
    public static void swapSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = array.length - 2; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //优化冒泡排序 如果在一次遍历中没有做任何交换，则该数组已经有序
    public static void optimizeBubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        boolean flag = true;
        for (int i = array.length - 2; i > 0 && flag; i--) {
            flag = false;
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, min, i);
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            if (temp < array[j]) {
                for (; j >= 0 && temp < array[j]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void insertSortWhile(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            if (temp < array[j]) {
                while (j >= 0 && temp < array[j]) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            for (; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;

        }
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array) {
        int increment = array.length / 2;
        while (increment >= 1) {
            for (int i = increment; i < array.length - increment + 1; i += increment) {
                int temp = array[i];
                int j = i;
                while (j > 0 && array[j - increment] > temp) {
                    array[j] = array[j - increment];
                    j = j - increment;
                }
                array[j] = temp;

            }
            increment = increment / 2;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        process(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void process(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(array, left, mid);
        process(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int p3 = 0;
        int[] temp = new int[right - left + 1];
        while (p1 <= mid && p2 <= right) {
            if (array[p1] < array[p2])
                temp[p3++] = array[p1++];
            else
                temp[p3++] = array[p2++];
        }
        while (p1 <= mid) {
            temp[p3++] = array[p1++];
        }
        while (p2 <= right) {
            temp[p3++] = array[p2++];
        }
        for (int j : temp) {
            array[left++] = j;
        }
    }

    public static void mergeSortWhile(int[] array) {
        int mergeSize = 1;
        int n = array.length;
        while (mergeSize < n) {
            int left = 0;
            while (left < n) {
                int mid = left + mergeSize - 1;
                if (mid >= n) {
                    break;
                }
                int right = mid + mergeSize;
                right = right >= n ? n - 1 : right;
                merge(array, left, mid, right);
                left = right + 1;
            }

            if (mergeSize > n / 2) {
                break;
            }
            mergeSize <<= 1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        quickProcess(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    private static void quickProcess(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right, right);
        quickProcess(array, left, index - 1);
        quickProcess(array, index + 1, right);

    }

    private static int partition(int[] array, int left, int right, int n) {
        int l = left - 1;
        int p = left;
        swap(array, right, n);
        while (p < right) {
            if (array[p] <= array[right]) {
                swap(array, l + 1, p);
                p++;
                l++;
            } else {
                p++;
            }
        }
        swap(array, right, l + 1);
        return l + 1;
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        swapSort(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        optimizeBubbleSort(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        selectSort(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        insertSort(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        insertSortWhile(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        mergeSort(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        insertSort2(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        shellSort(new int[]{3, 4, 9, 2, 1, 7, 6, 5});
        mergeSortWhile(new int[]{8, 3, 4, 9, 2, 1, 7, 6, 5});
        quickSort(new int[]{8, 3, 4, 9, 2, 1, 7, 6, 5});

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static class ArraySmallSum {

        public static int solution(int[] array) {
            int process = process(array, 0, array.length - 1);
            System.out.println(Arrays.toString(array));
            return process;

        }

        public static int process(int[] array, int left, int right) {
            if (left == right) {
                return 0;
            }
            int mid = left + ((right - left) >> 1);
            return process(array, left, mid) + process(array, mid + 1, right) + merge(array, left, mid, right);
        }

        public static int merge(int[] array, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int p1 = left;
            int p2 = mid + 1;
            int p = 0;
            int res = 0;
            while (p1 <= mid && p2 <= right) {
                res += array[p1] < array[p2] ? (right - p2 + 1) * array[p1] : 0;
                temp[p++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
            }
            while (p1 <= mid) {
                temp[p++] = array[p1++];
            }
            while (p2 <= right) {
                temp[p++] = array[p2++];
            }
            for (int i : temp) {
                array[left++] = i;
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(solution(new int[]{1, 2, 3}));
        }
    }

}
