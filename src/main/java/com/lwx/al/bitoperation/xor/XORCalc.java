package com.lwx.al.bitoperation.xor;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XORCalc {

    //数组中只有一种树出现奇数次其余出现偶数次
    public static int acquireOddTimesNum1(int[] arr) {
        int res = 0;
        for (int i : arr) {
            res ^= i;
        }
        return res;
    }

    //提取最右侧的1 n&(~n+1)

    // arr中，有两种数，出现奇数次
    public static int[] acquireOddTimesNum2(int[] arr) {
        int xorRes = 0;
        for (int i : arr) {
            xorRes ^= i;
        }
        //提取出最右侧的1 (这两种数在这个位置上必然有一个是0 一个是1)
        int temp = xorRes & (~xorRes + 1);
        int x = 0;
        for (int i : arr) {
            if ((i & temp) == temp) {
                x ^= i;
            }
        }
        return new int[]{x, x ^ xorRes};
    }

    //一个数中二进制位1的个数
    public static int bit1Counts(int x) {

        int temp = x;
        int res = 0;
        while (temp != 0) {
            res++;
            int rightOne = temp & (~temp + 1);
            temp ^= rightOne;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(acquireOddTimesNum1(new int[]{1, 2, 1, 3, 2, 4, 3}));
        System.out.println(Arrays.toString(acquireOddTimesNum2(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 5})));
        System.out.println(bit1Counts(7));
    }

}
