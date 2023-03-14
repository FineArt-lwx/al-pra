package com.lwx.al.sort;

import org.junit.Test;

import com.lwx.al.validator.RandomArrayGenerator;

public class MergeSortTest {

    @Test
    public void test() {
            SortTester.test(10000, RandomArrayGenerator.of(1000), MergeSort::sortByRecursion);

    }
}
