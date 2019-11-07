package com.haonan.leetcode.string;

/**
 * @Author rhaonan
 * @Data 2019/8/8
 * @Description 最长公共前缀
 */
public class Code14 {

    // 分治法
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length-1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int middle = (left + right)/2;
            String leftStr = longestCommonPrefix(strs, left, middle);
            String rightStr = longestCommonPrefix(strs, middle + 1, right);
            return commonPrefix(leftStr, rightStr);
        }
    }

    private String commonPrefix(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, min);
    }
}
