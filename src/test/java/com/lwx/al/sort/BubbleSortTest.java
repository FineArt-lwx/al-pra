package com.lwx.al.sort;

import org.junit.Test;

import com.lwx.al.validator.RandomArrayGenerator;

public class BubbleSortTest {

    @Test
    public void test() {
        SortTester.test(10000, RandomArrayGenerator.of(10000), BubbleSort::sort);
    }

    @Test
    public void testP() {
        SortTester.performanceTest(1, RandomArrayGenerator.of(100000, 100000),
                SelectSort::sort, BubbleSort::sort);
    }
}
