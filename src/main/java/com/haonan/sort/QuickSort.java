package com.haonan.sort;

import java.util.Arrays;

/**
 * @Author rhaonan
 * @Data 2019/3/27
 * @Description 快排算法 复杂度O(nlogn)
 */
public class QuickSort {

    public static void quickSort(int[] arrary) {
        if (arrary != null && arrary.length > 1) {
            quickSort(arrary, 0, arrary.length - 1);
        }
    }

    private static void quickSort(int[] arrary, int low, int high) {
        if (low < high && arrary != null) {
            int middle = partition(arrary, low, high);
            quickSort(arrary, low, middle - 1);
            quickSort(arrary, middle + 1, high);
        }
    }

    private static int partition(int[] arrary, int low, int high) {
        int flag = arrary[high];
        int i, j = low;
        for (i = j - 1; j < high; j++) {
            if (arrary[j] <= flag) {
                i++;
                swap(arrary, i, j);
            }
        }
        if (i + 1 != high) {
            swap(arrary, i+1, high);
        }

        return i+1;
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
        quickSort(arrary);
        System.out.println(Arrays.toString(arrary));
    }
}
