package com.zhoulychn.cases.algorithm.二分查找;

/**
 * Created by lewis on 2017/2/22.
 * 二分查找
 */
public class Case {


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Case.search(4, array, 0, array.length - 1));
    }


    public static int search(int result, int[] array, int lo, int hi) {

        if (lo > hi) {
            return -1;
        }

        if (result > array[(lo + hi) / 2]) {
            return search(result, array, (lo + hi) / 2 + 1, hi);
        }

        if (result < array[(lo + hi) / 2]) {
            return search(result, array, lo, (lo + hi) / 2 - 1);
        }

        return (lo + hi) / 2;
    }

}
