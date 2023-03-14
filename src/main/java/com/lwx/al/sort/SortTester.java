package com.lwx.al.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.google.common.base.Stopwatch;
import com.lwx.al.validator.RandomArrayGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortTester {

    public static void test(int scale, RandomArrayGenerator arrayGenerator, Consumer<int[]> consumer) {
        boolean succeed = true;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < scale; i++) {
            int[] array = arrayGenerator.array();
            int[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(array);
            consumer.accept(copy);
            if (!Arrays.equals(array, copy)) {
                succeed = false;
                log.info(Arrays.toString(array));
                log.info(Arrays.toString(copy));
                break;
            }
            log.info("已完成：第{}组用例：数组大小：{},已耗时(mills):{}", i + 1, array.length, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        stopwatch.stop();
        log.info("use mills:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        log.info(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void performanceTest(int scale, RandomArrayGenerator arrayGenerator, Consumer<int[]> sorter1, Consumer<int[]> sorter2) {
        List<int[]> arrays = new ArrayList<>(scale);
        List<int[]> copyArrays = new ArrayList<>(scale);
        for (int i = 0; i < scale; i++) {
            int[] array = arrayGenerator.array();
            int[] copy = Arrays.copyOf(array, array.length);
            arrays.add(array);
            copyArrays.add(copy);
        }
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < arrays.size(); i++) {
            sorter1.accept(arrays.get(i));
            int num = i + 1;
            if (num % 100 == 0) {
                log.info("sorter1 已完成：{},已耗时:{}", num, stopwatch.elapsed(TimeUnit.MILLISECONDS));
            }

        }
        stopwatch.stop();
        log.info("sorter1 use mills:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.reset();
        stopwatch.start();
        for (int i = 0; i < copyArrays.size(); i++) {
            sorter2.accept(copyArrays.get(i));
            int num = i + 1;
            if (num % 100 == 0) {
                log.info("sorter2 已完成：{},已耗时:{}", num, stopwatch.elapsed(TimeUnit.MILLISECONDS));
            }
        }
        stopwatch.stop();
        log.info("sorter2 use mills:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }

}
