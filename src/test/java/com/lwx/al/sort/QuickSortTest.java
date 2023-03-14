package com.lwx.al.sort;

import java.util.Arrays;

import org.junit.Test;

import com.lwx.al.validator.RandomArrayGenerator;

public class QuickSortTest {

    @Test
    public void test() {
        SortTester.test(10000, RandomArrayGenerator.of(10000), QuickSort::sort2);
    }

    @Test
    public void testP() {
        SortTester.performanceTest(1, RandomArrayGenerator.of(10000000), QuickSort::sort2, Arrays::sort);
    }
}
