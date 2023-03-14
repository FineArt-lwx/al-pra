package com.lwx.al.sort.search;

import org.junit.Test;

import com.lwx.al.search.BinarySearch;
import com.lwx.al.search.SearchTester;
import com.lwx.al.validator.RandomArrayGenerator;

public class BinarySearchTest {

    @Test
    public void test() {
        SearchTester.test(10000, RandomArrayGenerator.of(100), BinarySearch::search);
    }

    @Test
    public void testLeftIndex() {
        SearchTester.testLeftIndex(10000, RandomArrayGenerator.of(100), BinarySearch::searchLeftEqual);
    }

    @Test
    public void testRightIndex() {
        SearchTester.testRightIndex(100000, RandomArrayGenerator.of(1000), BinarySearch::searchRightEqual);
    }

    @Test
    public void testLocalMinimum() {
        SearchTester.testLocalMinimum(10000, RandomArrayGenerator.of(1000), BinarySearch::searchLocalMinimum);

    }
}
