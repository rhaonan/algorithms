package com.haonan.leetcode.interger;

/**
 * @Author rhaonan
 * @Data 2019/10/23
 * @Description  整数转罗马数字
 */
public class Code12 {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                sb.append(romans[index]);
                num -=nums[index];
            }
            index++;
        }
        return sb.toString();
    }

}
