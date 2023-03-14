package com.lwx.al.validator;

import java.util.Arrays;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class RandomArrayGenerator {

    Integer arrayRandomLimit;

    Integer fixArraySize;

    public static RandomArrayGenerator of(Integer arrayRandomLimit) {
        return new RandomArrayGenerator(arrayRandomLimit);
    }

    public static RandomArrayGenerator of(Integer arrayRandomLimit, Integer fixArraySize) {
        return new RandomArrayGenerator(arrayRandomLimit, fixArraySize);
    }

    public RandomArrayGenerator(Integer arrayRandomLimit) {
        this.arrayRandomLimit = arrayRandomLimit;
    }

    public int[] array() {
        if (fixArraySize != null) {
            return fixLengthArray(arrayRandomLimit, fixArraySize);
        }
        return array(arrayRandomLimit);
    }

    public int[] adjoinDistinct() {
        if (fixArraySize != null) {
            return fixLengthAdjoinDistinctArray(arrayRandomLimit, fixArraySize);
        }
        return adjoinDistinct(arrayRandomLimit);

    }

    public int[] adjoinDistinct(int limit) {
        int v = (int) (Math.random() * (limit + 1));
        int[] array = new int[v];
        for (int i = 0; i < array.length; i++) {
            int value = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
            while (i != 0 && array[i - 1] == value) {
                value = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
            }
            array[i] = value;
        }
        return array;

    }

    public static int[] fixLengthAdjoinDistinctArray(int limit, int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            int value = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
            while (i != 0 && array[i] == value) {
                value = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
            }
            array[i] = value;
        }
        return array;

    }

    public static int[] array(int limit) {
        int v = (int) (Math.random() * (limit + 1));
        int[] array = new int[v];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
        }
        return array;

    }

    public static int[] fixLengthArray(int limit, int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (limit + 1)) - (int) (Math.random() * (limit + 1));
        }
        return array;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Arrays.toString(array(1000)));
        }
    }

}
