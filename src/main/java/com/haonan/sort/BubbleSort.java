package com.haonan.sort;

import java.util.Arrays;

/**
 * @Author rhaonan
 * @Data 2019/3/27
 * @Description 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }

    }

    private static void swap(int[] arrary, int i, int j) {
        if (i != j) {
            int temp = arrary[i];
            arrary[i] = arrary[j];
            arrary[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arrary = {5, 12, 42, 25, 36};
        bubbleSort(arrary);
        System.out.println(Arrays.toString(arrary));
    }
}
