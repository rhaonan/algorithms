package com.haonan.leetcode.interger;

/**
 * @Author rhaonan
 * @Data 2019/10/23
 * @Description 盛最多水的容器
 */
public class Code11 {

    // 遍历算法
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = (j-i) * Math.min(height[i], height[j]);
                max = temp > max ? temp:max;
            }
        }
        return max;
    }

    // 双指针法
    public int maxArea2(int[] height) {
        int len = height.length;
        int l = 0, r = len-1;
        int max = 0;

        while ( r - l >= 1) {
            int tmp = (r - l) * Math.min(height[l], height[r]);
            max = tmp > max ? tmp : max;
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}
