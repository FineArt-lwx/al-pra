package com.lwx.al.search;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.google.common.base.Stopwatch;
import com.lwx.al.validator.RandomArrayGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchTester {

    public static void test(int scale, RandomArrayGenerator arrayGenerator, BiFunction<int[], Integer, Integer> function) {
        boolean succeed = true;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < scale; i++) {
            int[] array = arrayGenerator.array();
            Arrays.sort(array);
            int value = (int) ((arrayGenerator.getArrayRandomLimit() + 1) * Math.random()) - (int) (arrayGenerator.getArrayRandomLimit() * Math.random());
            int expect = simpleSearch(array, value);
            Integer target = function.apply(array, value);
            if (!((target == -1 && expect == -1) || (target != -1 && expect != -1))) {
                succeed = false;
                log.info("expect:{}", expect);
                log.info("target:{}", target);
                break;
            }
            log.info("已完成：第{}组用例：数组大小：{},已耗时(mills):{}", i + 1, array.length, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        stopwatch.stop();
        log.info("use mills:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        log.info(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void testLeftIndex(int scale, RandomArrayGenerator arrayGenerator, BiFunction<int[], Integer, Integer> function) {
        boolean succeed = true;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < scale; i++) {
            int[] array = arrayGenerator.array();
            Arrays.sort(array);
            int value = (int) ((arrayGenerator.getArrayRandomLimit() + 1) * Math.random()) - (int) (arrayGenerator.getArrayRandomLimit() * Math.random());
            int expect = simpleSearch(array, value);
            Integer target = function.apply(array, value);
            if (expect != target) {
                succeed = false;
                log.info("expect:{}", expect);
                log.info("target:{}", target);
                break;
            }
            log.info("已完成：第{}组用例：数组大小：{},已耗时(mills):{}", i + 1, array.length, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        stopwatch.stop();
        log.info("use mills:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        log.info(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void testRightIndex(int scale, RandomArrayGenerator arrayGenerator, BiFunction<int[], Integer, Integer> function) {
        boolean succeed = true;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < scale; i++) {
            int[] array = arrayGenerator.array();
            Arrays.sort(array);
            int value = (int) ((arrayGenerator.getArrayRandomLimit() + 1) * Math.random()) - (int) (arrayGenerator.getArrayRandomLimit() * Math.random());
            log.info("source:{},findValue:{}", Arrays.toString(array), value);
            int expect = simpleRightSearch(array, value);
            Integer target = function.apply(array, value);
            if (expect != target) {
                succeed = false;
                log.info("expect:{}", expect);
                log.info("target:{}", target);
                break;
            }
            log.info("已完成：第{}组用例：数组大小：{},已耗时(mills):{}", i + 1, array.length, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        stopwatch.stop();
        log.info("use mills:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        log.info(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void testLocalMinimum(int scale, RandomArrayGenerator arrayGenerator, Function<int[], Integer> function) {
        boolean succeed = true;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < scale; i++) {
            int[] array = arrayGenerator.adjoinDistinct();
            Integer target = function.apply(array);
            if (!localMinimumRight(array, target)) {
                succeed = false;
                log.info("source:{}", Arrays.toString(array));
                log.info("result:{}", target);
                break;
            }
            log.info("已完成：第{}组用例：数组大小：{},已耗时(mills):{}", i + 1, array.length, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        stopwatch.stop();
        log.info("use mills:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        log.info(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static int simpleSearch(int[] array, int value) {
        if (array == null || array.length == 0) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }
        }
        return -1;

    }

    private static boolean localMinimumRight(int[] array, int localMiniIndex) {
        if (localMiniIndex == -1) {
            return true;
        }
        if (array.length == 1 || (localMiniIndex == 0 && array[localMiniIndex] < array[localMiniIndex + 1])) {
            return true;
        }
        if (localMiniIndex == array.length - 1 && array[localMiniIndex] < array[localMiniIndex - 1]) {
            return true;
        }
        return array[localMiniIndex] < array[localMiniIndex - 1] && array[localMiniIndex] < array[localMiniIndex + 1];

    }

    public static int simpleRightSearch(int[] array, int value) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                result = i;
                continue;
            }
            if (result != -1) {
                return result;
            }
        }
        return result;

    }
}
