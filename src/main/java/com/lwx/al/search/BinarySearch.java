package com.lwx.al.search;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearch {

    //普通二分查找
    public static int search(int[] array, int x) {
        log.info("source:{},find:{}", array, x);

        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == x) {
                return mid;
            }
            if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    /**
     * 寻找相等数的左边界
     */
    public static int searchLeftEqual(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == array.length || array[left] != target) {
            return -1;
        }
        return left;

    }

    public static int searchLeftEqual2(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int temp = -1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                temp = mid;
                right = mid - 1;
            }
        }
        if (temp == array.length || array[temp] != target) {
            return -1;
        }
        return temp;

    }

    /**
     * 寻找相等数的左边界
     */
    public static int searchRightEqual(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == 0 || array[left - 1] != target) {
            return -1;
        }
        return left - 1;

    }

    //局部最小值问题 数组中某个位置的值比左边位置小 且比右边位置小 则这个值为局部最小 tips:看数据趋势

    public static int searchLocalMinimum(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1 || array[0] < array[1]) {
            return 0;
        }
        if (array[array.length - 1] < array[array.length - 2]) {
            return array.length - 1;
        }
        int left = 1;
        int right = array.length - 2;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] > array[mid + 1]) {
                left = mid + 1;
            } else if (array[mid] > array[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;

    }
}
