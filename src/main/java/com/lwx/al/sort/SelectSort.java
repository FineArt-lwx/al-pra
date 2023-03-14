package com.lwx.al.sort;

import com.lwx.al.util.SwapUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelectSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            SwapUtils.swap(array, minIndex, i);
        }
    }

    //    public static void test(int scale, Consumer<int[]> consumer) {
    //        boolean succeed = true;
    //        Stopwatch stopwatch = Stopwatch.createStarted();
    //        for (int i = 0; i < scale; i++) {
    //            int[] array = RandomArrayGenerator.array(scale);
    //            int[] copy = Arrays.copyOf(array, array.length);
    //            Arrays.sort(array);
    //            consumer.accept(copy);
    //            if (!Arrays.equals(array, copy)) {
    //                succeed = false;
    //                log.info(Arrays.toString(array));
    //                log.info(Arrays.toString(copy));
    //                break;
    //            }
    //            log.info("已完成：第{}组用例：数组大小：{},已耗时(mills):{}", i + 1, array.length, stopwatch.elapsed(TimeUnit.MILLISECONDS));
    //        }
    //        stopwatch.stop();
    //        log.info("use mills:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    //        log.info(succeed ? "Nice!" : "Fucking fucked!");
    //    }


}
