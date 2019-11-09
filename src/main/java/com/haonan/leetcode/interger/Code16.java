package com.haonan.leetcode.interger;

import java.util.Arrays;

/**
 * @Author rhaonan
 * @Data 2019/8/8
 * @Description 最接近的三数之和
 */
public class Code16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[3];
        for (int i = 0; i < nums.length; i++) {
            int left  = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs((result - target))) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}
