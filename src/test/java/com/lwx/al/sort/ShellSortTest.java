package com.lwx.al.sort;

import org.junit.Test;

import com.lwx.al.validator.RandomArrayGenerator;

public class ShellSortTest {

    @Test
    public void test() {
        SortTester.test(1, RandomArrayGenerator.of(100), ShellSort::sort);
    }

    @Test
    public void testP() {
        SortTester.performanceTest(1, RandomArrayGenerator.of(100000), InsertSort::sort, ShellSort::sort);
    }

    @Test
    public void testIns() {
        SortTester.test(1000, RandomArrayGenerator.of(10000), InsertSort::sort);
    }
}
