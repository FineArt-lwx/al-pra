package com.lwx.al.sort;

import java.util.Arrays;

import org.junit.Test;

import com.lwx.al.validator.RandomArrayGenerator;

public class HeapSortTest {

    @Test
    public void test() {
        SortTester.test(10000, RandomArrayGenerator.of(1000), HeapSort::sort);
    }

    @Test
    public void testP() {
        SortTester.performanceTest(1, RandomArrayGenerator.of(1000000), Arrays::sort, HeapSort::sort);
    }

    @Test
    public void testP2() {
        SortTester.performanceTest(1, RandomArrayGenerator.of(1000000), HeapSort::sort, MergeSort::sortByRecursion);
    }

    @Test
    public void testP3() {
        SortTester.performanceTest(1, RandomArrayGenerator.of(1000000,1000000), Arrays::sort, MergeSort::sortByRecursion);
    }

}
