package com.lwx.al.sort;

import java.util.Arrays;

import org.junit.Test;

import com.lwx.al.validator.RandomArrayGenerator;

public class SelectSortTest {

    @Test
    public void test1() {
        SortTester.performanceTest(1, new RandomArrayGenerator(1000000), Arrays::sort,
                SelectSort::sort);
    }
}
